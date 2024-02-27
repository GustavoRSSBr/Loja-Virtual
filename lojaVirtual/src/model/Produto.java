package model;

public class Produto {
    private String id;
    private String marca;
    private String modelo;
    private String cor;
    private String tamanho;
    private double precoCusto;
    private double precoVenda;
    private int quantidadeEmEstoque;


    public Produto(String id, String marca, String modelo, String cor, String tamanho, double precoCusto, double precoVenda, int quantidadeEmEstoque) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.tamanho = tamanho;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidade) {
        this.quantidadeEmEstoque = quantidade;
    }

    @Override
    public String toString() {
        return 
        "Id: " + id +
        "\nMarca: " + marca +
        "\nModelo: " + modelo +
        "\nCor: " + cor +
        "\nTamanho: " + tamanho + 
        "\nPreço de Custo: R$" + precoCusto +
        "\nPreço de Venda: R$" + precoVenda +
        "\nQuantidade no estoque: " + quantidadeEmEstoque;
    }
}

