package view;
import java.util.Scanner;

public class View {
    private ControleCompra controleCompra;
    private ControleUsuario controleUsuario;
    private ControleEstoque controleEstoque;

   

    // Getters e Setters para controleCompra
    public ControleCompra getControleCompra() {
        return controleCompra;
    }

    public void setControleCompra(ControleCompra controleCompra) {
        this.controleCompra = controleCompra;
    }

    // Getters e Setters para controleUsuario
    public ControleUsuario getControleUsuario() {
        return controleUsuario;
    }

    public void setControleUsuario(ControleUsuario controleUsuario) {
        this.controleUsuario = controleUsuario;
    }

    // Getters e Setters para controleEstoque
    public ControleEstoque getControleEstoque() {
        return controleEstoque;
    }

    public void setControleEstoque(ControleEstoque controleEstoque) {
        this.controleEstoque = controleEstoque;
    }

	public void menuPrincipal() {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		do {
			System.out.println("----- Menu Principal -----");
			System.out.println("1. Menu de Compras");
			System.out.println("2. Menu de Estoque");
			System.out.println("3. Menu de Usuário");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			switch (opcao) {
				case 1:
					menuCompras(scanner);
					break;
				case 2:
					menuEstoque(scanner);
					break;
				case 3:
					menuUsuario(scanner);
					break;
				case 4:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != 4);
		scanner.close();
	}

	public void menuCompras(Scanner scanner) {
		while (true) {
			System.out.println("----- Menu de Compras -----");
			System.out.println("1. Realizar Compra");
			System.out.println("2. Voltar");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();
			switch (opcao) {
				case 1:
					realizarCompra(scanner);
					break;
				case 2:
					return;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	public void menuEstoque(Scanner scanner) {
		System.out.println("----- Menu de Estoque -----");
		System.out.println("1. Visualizar Produtos");
		System.out.println("2. Adicionar Produto");
		System.out.println("3. Remover Produto");
		System.out.println("4. Voltar");
		System.out.print("Escolha uma opção: ");
		int opcao = scanner.nextInt();
		switch (opcao) {
			case 1:
				visualizarProdutos();
				break;
			case 2:
				adicionarProduto();
				break;
			case 3:
				removerProduto();
				break;
			case 4:
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
		}
	}

	public void menuUsuario(Scanner scanner) {
		System.out.println("----- Menu de Usuário -----");
		System.out.println("1. Alterar Senha");
		System.out.println("2. Logout");
		System.out.print("Escolha uma opção: ");
		int opcao = scanner.nextInt();
		switch (opcao) {
			case 1:
				alterarSenha();
				break;
			case 2:
				System.out.println("Logout realizado.");
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
		}
	}

	private void realizarCompra(Scanner scanner) {
		// lógica para realizar uma compra
		System.out.println("Compra realizada com sucesso.");
	}

	private void visualizarProdutos() {
		//lógica para visualizar os produtos em estoque
		System.out.println("Produtos em estoque:");
		// listar os produtos presentes no controle de estoque
	}

	private void adicionarProduto() {
		// lógica para adicionar um novo produto ao estoque
		System.out.println("Produto adicionado ao estoque.");
	}

	private void removerProduto() {
		// lógica para remover um produto do estoque
		System.out.println("Produto removido do estoque.");
	}

	private void alterarSenha() {
		//lógica para alterar a senha do usuário
		System.out.println("Senha alterada com sucesso.");
	}
}

