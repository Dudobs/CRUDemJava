package DAO;

import factory.ConnectionMySQL;
import models.Cliente;
import models.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidoDAO {

    public void create(Pedido pedido) {

        //Query a ser usada no banco
        String sqlGeTP = "SELECT total_pedidos FROM Cliente WHERE id = ?";
        String sqlInsert = "INSERT INTO Pedido (id_cliente, pedido, preco) VALUES (?, ?, ?)";
        String sqlUpdateTP = "UPDATE Cliente SET total_pedidos = total_pedidos + 1 WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmInsert = null;
        PreparedStatement pstmUpdateTP = null;
        PreparedStatement pstmGetTP = null;

        //Classe que recupera os dados do banco <<SELECT>>
        ResultSet rset = null;

        try {
            //Cria conexão com o banco de dados
            conn = ConnectionMySQL.createConnectionToMySQL();

            //Criando uma prepareStatement, classe que executa a query
            pstmInsert = conn.prepareStatement(sqlInsert);
            pstmUpdateTP = conn.prepareStatement(sqlUpdateTP);
            pstmGetTP = conn.prepareStatement(sqlGeTP);

            //Adicionando valores esperados pela query de atualização
            pstmGetTP.setInt(1, pedido.getIdCliente());

            //Executando a query que recupera o total de pedidos
            rset = pstmGetTP.executeQuery();

            //Adicionando valores esperados pela query de inserção
            pstmInsert.setInt(1, pedido.getIdCliente());
            pstmInsert.setString(2, pedido.getDetalhes());
            if(rset.next()) {
                int TP = rset.getInt("total_pedidos");

                if(TP == 0) {
                    pstmInsert.setDouble(3, pedido.setDesconto());
                } else {
                    pstmInsert.setDouble(3, pedido.getPreco());
                }
            }

            //Adicionando valores esperados pela query de atualização
            pstmUpdateTP.setInt(1, pedido.getIdCliente());

            //Executa as queries
            pstmInsert.execute();
            pstmUpdateTP.execute();
            System.out.println("Pedido feito com sucesso!");

        } catch (Exception e) {
            //Printa o erro
            e.printStackTrace();
        } finally {

            //Fecha as conexões após o sucesso dos comandos acima
            try {
                if(rset != null) {
                    rset.close();
                }

                if(pstmInsert != null) {
                    pstmInsert.close();
                }

                if(pstmUpdateTP != null) {
                    pstmUpdateTP.close();
                }

                if(pstmGetTP != null) {
                    pstmGetTP.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
