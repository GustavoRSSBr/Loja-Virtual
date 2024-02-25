package model;

public class Item {
    private Produto produto;
    private int quantidade;
    private double subTotal;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subTotal = produto.getPrecoCusto() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getSubtotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    // Exibir informações do item
    @Override
    public String toString() {
        return 
        "Nome: " + produto + 
        "\nPreço: R$" + subTotal +
        "\nQuantidade no estoque: " + quantidade;
    }
}