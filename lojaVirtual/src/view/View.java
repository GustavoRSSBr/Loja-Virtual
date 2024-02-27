package view;

import controller.ControleCompra;
import controller.ControleEstoque;
import controller.ControleUsuario;
import model.Produto;

import java.time.LocalDate;
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

    private void realizarCompra(Scanner scanner) {
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
                adicionarProduto(scanner);
                break;
            case 3:
                removerProduto(scanner);
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public void menuUsuario(Scanner scanner) {
        System.out.println("----- Menu de Usuário -----");
        System.out.println("1. login");
		System.out.println("2. cadastrar");
        System.out.println("2. voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                logarUsuario(scanner);
                break;
			case 2:
				cadastrarUsuario(scanner);
				break;	
            case 3:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

	private void cadastrarUsuario(Scanner scanner) {

            System.out.println("**Cadastro de Usuário - Login**");

            System.out.print("Digite seu e-mail: ");
            String email = scanner.nextLine();

            if(!controleUsuario.verificarEmail(email)){
                System.out.println("Email já cadastrado");
                return;
            }

            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();


            if(!controleUsuario.validarSenha(senha)) {
                System.out.println("Senha inválida, ela deve conter no mínimo 8 caracteres, 1 Letra Maiuscula, 1 Número, 1 caractere especial (@,#,$ etc...)");
                return;
            }

            System.out.println("**Cadastro de Usuário - Dados do Cliente**");

            System.out.print("Digite seu nome completo: ");
            String nome = scanner.nextLine();

            System.out.print("Digite seu endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("Digite seu telefone: ");
            String telefone = scanner.nextLine();

            System.out.print("Digite sua data de nascimento (dd/MM/aaaa): ");
            LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

            System.out.print("Digite seu saldo: ");
            double saldo = scanner.nextDouble();

            System.out.print("Digite seu CPF ou CNPJ: ");
            String cpfOuCnpj = scanner.nextLine();

        }

	private void logarUsuario(Scanner scanner) {
        System.out.println("Digite seu e-mail:");
        String email = scanner.nextLine();

        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        if (this.controleUsuario.logar(email, senha)) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("E-mail ou senha inválidos. Tente novamente.");
        }
    }


    private void visualizarProdutos() {
        this.controleEstoque.listar();
    }

    private void adicionarProduto(Scanner scanner) {
        System.out.println("Digite o ID do produto:");
        String id = scanner.nextLine();

        System.out.println("Digite a marca do produto:");
        String marca = scanner.nextLine();

        System.out.println("Digite o modelo do produto:");
        String modelo = scanner.nextLine();

        System.out.println("Digite a cor do produto:");
        String cor = scanner.nextLine();

        System.out.println("Digite o tamanho do produto:");
        String tamanho = scanner.nextLine();

        System.out.println("Digite o preço de custo do produto:");
        double precoCusto = scanner.nextDouble();

        System.out.println("Digite o preço de venda do produto:");
        double precoVenda = scanner.nextDouble();

        System.out.println("Digite a quantidade em estoque do produto:");
        int quantidadeEmEstoque = scanner.nextInt();

        if (controleEstoque.cadastrarProduto(new Produto(id, marca, modelo, cor, tamanho, precoCusto, precoVenda, quantidadeEmEstoque))) {
            System.out.println("Produto cadastrado com sucesso");
        }
    }

    private void removerProduto(Scanner scanner) {
        System.out.println("Digite o ID do produto que deseja remover: ");
        String idProduto = scanner.next();
        controleEstoque.removerProduto(idProduto);
    }

}

