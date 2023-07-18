package models;

public class Pedido implements DescontoPrimeiroPedido{
    private String detalhes;
    private double preco;
    private int idCliente;

    public Pedido(int idCliente, String detalhes, double preco) {
        this.idCliente = idCliente;
        this.detalhes = detalhes;
        this.preco = preco;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public double setDesconto() {
        return this.preco -= (this.preco * desconto);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "detalhes='" + detalhes + '\'' +
                ", preco=" + preco +
                '}';
    }
}
