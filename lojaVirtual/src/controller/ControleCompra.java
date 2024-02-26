package controller;

import model.Item;
import model.Pedido;
import model.Pessoa;
import model.Produto;

import java.time.LocalDateTime;
import java.util.List;

public class ControleCompra {
	
	
	private ControleEstoque controleEstoque;
	
	private ControleUsuario controleUsuario;

    private Pessoa pessoaDoPedido;

    private Pedido pedidoDoCliente;
	public ControleCompra(ControleEstoque controleEstoque, ControleUsuario controleUsuario) {
		this.controleEstoque = controleEstoque;
		this.controleUsuario = controleUsuario;
        this.pessoaDoPedido = controleUsuario.getUsuarioLogado().getPessoa();
        this.pedidoDoCliente = new Pedido();
	}

	public void escolherItem(int id,int quantidade) {
		controleEstoque.listar();
		
		Produto produtoDoEstoque = controleEstoque.buscarProduto(id);
		Item receberItem = new Item(produtoDoEstoque, quantidade);
	
		
	}
	public void limparPedido() {
		List<Item> listaDeItensDoPedido = pedidoDoCliente.getListaDeItens();
		listaDeItensDoPedido = null;
	}

	public void depositar(double saldo) {
        double novoSaldo = pessoaDoPedido.getSaldo() + saldo;
        pessoaDoPedido.setSaldo(novoSaldo);
	}

	public void comprar() {
        double saldoDocliente = pessoaDoPedido.getSaldo();
        double valorDoPedido = pedidoDoCliente.valorTotal();

        if(saldoDocliente >= valorDoPedido){
            double novoSaldo = saldoDocliente - valorDoPedido;
            pessoaDoPedido.setSaldo(novoSaldo);
        }else{
            System.out.println("Saldo Insuficiente");
        }
	}
}
