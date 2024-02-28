package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Classe Pedido
public class Pedido {
    private UUID numeroPedido;
    private Pessoa cliente;
    private LocalDateTime dataDoPedido;
    private List<Item> listaDeItens;
    
    public Pedido(Pessoa cliente) {
        this.numeroPedido = UUID.randomUUID();
        this.cliente = cliente;
        this.listaDeItens = new ArrayList<>();
        this.dataDoPedido = LocalDateTime.now();
    }

    public Pedido() {
    }

    public double valorTotal(){
        double total = 0;
        for (Item item : listaDeItens){
            total += item.getSubtotal();
        }
        return total;
    }
    
    public UUID getNumeroPedido() {
        return numeroPedido;
    }
    
    public Pessoa getCliente() {
        return cliente;
    }

    public LocalDateTime getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(LocalDateTime dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public List<Item> getListaDeItens() {
        return listaDeItens;
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
