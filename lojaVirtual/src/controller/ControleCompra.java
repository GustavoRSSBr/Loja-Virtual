package controller;

public class ControleCompra {
	
	
	private ControleEstoque controleEstoque;
	
	private ControleUsuario controleUsuario;
	
	public ControleCompra(ControleEstoque controleEstoque, ControleUsuario controleUsuario) {
		this.controleEstoque = controleEstoque;
		this.controleUsuario = controleUsuario;
	}
	
	Pessoa pessoaDoPedido = controleUsuario.getPessoa();
	
	Pedido pedido = new Pedido();
	pedido.setDataPedido(LocalDateTime.now());
	pedido.setCliente(pessoaDoPedido);
	
	
	public void escolherItem(int id,int quantidade) {
		controleEstoque.listar();
		
		Produto produtoDoEstoque = controleEstoque.buscarProduto(id);
		Item receberItem = new Item(produtoDoEstoque, quantidade);
	
		
	}
	public void limparPedido() {
		
		List<Itens> listaDeItensDoPedido = pedido.getListaDeItens();
		listaDeItensDoPedido = null;
		
	}
	public double depositar(double saldo) {
		pessoaDoPedido.setSaldo() = pessoaDoPedido.getSaldo() + saldo;
		
		
		
		return pessoaDoPedido.getSaldo();
	
		
	}
	public double comprar() {
	pessoaDoPedido.setSaldo() = pessoaDoPedido.getSaldo() - pedido.getTotal();
	
	return pessoa.getSaldo();
	
	
	}

}
