package DAO;

import factory.ConnectionMySQL;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    //CREATE
    public void create(Cliente cliente) {

        //Query a ser usada no banco
        String sqlInsert = "INSERT INTO Cliente (nome, endereco, telefone, total_pedidos) VALUES (?, ?, ?, 0)";

        Connection conn = null;
        PreparedStatement pstmInsert = null;

        try {
            //Cria conexão com o banco de dados
            conn = ConnectionMySQL.createConnectionToMySQL();

            //Criando uma prepareStatement, classe que executa a query
            pstmInsert = conn.prepareStatement(sqlInsert);

            //Adicionando valores esperados pela query
            pstmInsert.setString(1, cliente.getNome());
            pstmInsert.setString(2, cliente.getEndereco());
            pstmInsert.setString(3, cliente.getTelefone());

            //Executa as queries
            pstmInsert.execute();
            System.out.println("Cliente salvo com sucesso!");

        } catch (Exception e) {
            //Printa o erro
            e.printStackTrace();
        } finally {

            //Fecha as conexões após o sucesso dos comandos acima
            try {
                if(pstmInsert != null) {
                    pstmInsert.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //UPDATE
    public void update(Cliente cliente) {

        //Query a ser usada no banco
        String sql = "UPDATE Cliente SET nome = ?, endereco = ?, telefone = ? " + "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria conexão com o banco de dados
            conn = ConnectionMySQL.createConnectionToMySQL();

            //Criando uma prepareStatement, classe que executa a query
            pstm = conn.prepareStatement(sql);

            //Adicionando valores esperados pela query
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEndereco());
            pstm.setString(3, cliente.getTelefone());
            // ID do cliente a ser atualizado
            pstm.setInt(4, cliente.getId());

            //Executa a query
            pstm.execute();
            System.out.println("Cliente atualizado com sucesso!");

        } catch (Exception e) {
            //Printa o erro
            e.printStackTrace();
        } finally {

            //Fecha as conexões após o sucesso dos comandos acima
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //DELETE
    public void deleteByID(int id) {

        //Query a ser usada no banco
        String sql = "DELETE FROM Cliente WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria conexão com o banco de dados
            conn = ConnectionMySQL.createConnectionToMySQL();

            //Criando uma prepareStatement, classe que executa a query
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            //Executa a query
            pstm.execute();
            System.out.println("Cliente deletado com sucesso!");

        } catch (Exception e) {
            //Printa o erro
            e.printStackTrace();
        } finally {

            //Fecha as conexões após o sucesso dos comandos acima
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //SELECT
    public List<Cliente> getClientes(){

        String sql = "SELECT * FROM Cliente";

        List<Cliente> clientes = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que recupera os dados do banco <<SELECT>>
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()) {

                Cliente cliente = new Cliente();

                //Recuperar os dados
                cliente.setId(rset.getInt("id"));
                cliente.setNome(rset.getString("nome"));
                cliente.setEndereco(rset.getString("endereco"));
                cliente.setTelefone(rset.getString("telefone"));
                cliente.setTotalPedidos(rset.getInt("total_pedidos"));

                clientes.add(cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rset != null) {
                    rset.close();
                }

                if(pstm != null) {
                    pstm.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clientes;
    }
}
