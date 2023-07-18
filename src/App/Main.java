package App;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import models.Cliente;
import models.Pedido;

public class Main {
    public static void main(String[] args) {

        /*#################  CRUD  EM  JAVA - CLIENTES #################*/

        //CD01 - Objeto instanciado para executar as queries (INSERTE, UPDATE, DELETE, SELECT)
        ClienteDAO CD01 = new ClienteDAO();

        //CREATE ###
        //Cliente cliente01 = new Cliente("Dario Pintor", "Asa Norte", "6198760022");
        //CD01.create(cliente01);

        //cliente02 - Objeto com os dados a serem atualizados
        //Cliente cliente02 = new Cliente("Dario Pintor", "Asa Sul", "6169241666");

        //cliente02.setId(7); // Id do cliente a ser atualizado

        //UPDATE ###
        //CD01.update(cliente02);

        //DELETE ###
        //CD01.deleteByID(8);

        //SELECT ###
        for(Cliente c: CD01.getClientes()) {
            System.out.println( "\nCliente: " + c.getNome() +
                                "\n\tID: " + c.getId() +
                                "\n\tEndereço: " + c.getEndereco() +
                                "\n\tTelefone: " + c.getTelefone() +
                                "\n\tTotal de pedidos: " + c.getTotalPedidos());
        }

        /*#################  CRUD  EM  JAVA - PEDIDOS #################*/

        PedidoDAO PD01 = new PedidoDAO();

        Pedido pedido01 = new Pedido(7, "Pizza", 10.00);

        PD01.create(pedido01);




        /*#################  MAIN  #################*/

        /*Cliente cliente01 = new Cliente("Dudu", "Asa Norte", "61940028922");

        cliente01.fazerPedido(1,"Pizza de Bacon", 50.00, cliente01);

        System.out.println(cliente01.getPedidos());
        System.out.println(cliente01.getTotalPedidos());

        cliente01.fazerPedido(1, "X-burguer", 23.69, cliente01);

        System.out.println(cliente01.getPedidos());
        System.out.println(cliente01.getTotalPedidos());*/
    }
}