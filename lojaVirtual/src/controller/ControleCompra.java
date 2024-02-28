package controller;

import model.Item;
import model.Pedido;
import model.Pessoa;
import model.Produto;

public class ControleCompra {
	private final ControleEstoque controleEstoque;
	
	private final ControleUsuario controleUsuario;

	private Pessoa pessoaDoPedido;
	private Pedido pedidoDoCliente;



	public ControleCompra(ControleEstoque controleEstoque, ControleUsuario controleUsuario) {
		this.controleEstoque = controleEstoque;
		this.controleUsuario = controleUsuario;
	}

	public void iniciarCompra(){
		pessoaDoPedido = controleUsuario.getUsuarioLogado().getPessoa();
		pedidoDoCliente = new Pedido(pessoaDoPedido);
	}

	public void mostrarPedido(){
		System.out.println(pedidoDoCliente);
	}



	public void escolherItem(String id,int quantidade) {
		Produto produtoDoEstoque = controleEstoque.buscarProduto(id);

		if(controleEstoque.verificarQuantidadeNoEstoque(produtoDoEstoque, quantidade)){
			pedidoDoCliente.getListaDeItens().add(new Item(produtoDoEstoque, quantidade));
		} else {
			System.out.println("Produto ou quantidade indisponível");
		}
	}
	public void limparPedido() {
		pedidoDoCliente.getListaDeItens().clear();
	}

	public void depositar(double saldo) {
        double novoSaldo = pessoaDoPedido.getSaldo() + saldo;
        pessoaDoPedido.setSaldo(novoSaldo);
	}

	public void comprar() {
		double saldoDocliente = pessoaDoPedido.getSaldo();
		double valorDoPedido = pedidoDoCliente.valorTotal();

		if(saldoDocliente >= valorDoPedido){
			if(controleEstoque.removerQuantidadeDoEstoque(pedidoDoCliente.getListaDeItens())){
				double novoSaldo = saldoDocliente - valorDoPedido;
				pessoaDoPedido.setSaldo(novoSaldo);
				limparPedido();
			}else{
				System.out.println("Erro ao atualizar o estoque");
			}
		}else{
			System.out.println("Saldo Insuficiente");
		}
	}
}
