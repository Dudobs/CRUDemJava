package models;

public class Cliente extends Pessoa{
    private String endereco;
    private String telefone;
    private int totalPedidos;

    private Pedido pedidos;

    public Cliente(){}

    public Cliente(String nome, String endereco, String telefone) {
        super.setNome(nome);
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getTotalPedidos() {
        return totalPedidos;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTotalPedidos(int totalPedidos) {
        this.totalPedidos = totalPedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido fazerPedido(int idCliente, String detalhes, double preco, Cliente cliente) {
        Pedido pedido = new Pedido(idCliente, detalhes, preco);

        if(cliente.getTotalPedidos() == 0) {
            pedido.setDesconto();
        }
        int Pedidos = cliente.getTotalPedidos();
        cliente.setTotalPedidos(Pedidos+1);

        setPedidos(pedido);
        return pedido;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", totalPedidos=" + totalPedidos +
                '}';
    }
}
