package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Classe Pedido
public class Pedido {
    private String numeroPedido;
    private Pessoa cliente;
    private LocalDateTime dataDoPedido;
    private List<Item> listaDeItens;
    
    public Pedido(String numeroPedido, Pessoa cliente) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.listaDeItens = new ArrayList<>();
    }

    public double valorTotal(){
        double total = 0;
        for (Item item : listaDeItens){
            total += item.getSubtotal();
        }
        return total;
    }
    
    public String getNumeroPedido() {
        return numeroPedido;
    }
    
    public Pessoa getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return
        "Numero do Pedido: " + numeroPedido +
        "\nCliente: " + cliente +
        "\nData do Pedido: " + dataDoPedido +
        "\nLista de Itens: " + listaDeItens +
        "\nValor total: R$" + valorTotal();
    }
}
