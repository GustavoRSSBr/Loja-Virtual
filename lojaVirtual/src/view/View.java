package view;

import controller.ControleCompra;
import controller.ControleEstoque;
import controller.ControleUsuario;
import model.*;
import util.ValidadorCPFouCNPJ;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class View {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
            System.out.println("1. Menu de Usuário");
            if (controleUsuario.getPermissao().equals("ADM")) {
                System.out.println("2. Menu Estoque");
            } else if (controleUsuario.getPermissao().equals("CLIENTE")) {
                System.out.println("2. Menu Compras");
            }
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    menuUsuario(scanner);
                    break;
                case 2:
                    if (controleUsuario.getPermissao().equals("ADM")) {
                        menuEstoque(scanner);
                    } else if (controleUsuario.getPermissao().equals("CLIENTE")) {
                        menuCompras(scanner);
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
        scanner.close();
    }

    public void menuCompras(Scanner scanner) {
        controleCompra.iniciarCompra();
        while (true) {
            System.out.println("----- Menu de Compras -----");
            System.out.println("0. Visualizar produtos");
            System.out.println("1. Escolher Item do pedido");
            System.out.println("2. Limpar pedido");
            System.out.println("3. Depositar");
            System.out.println("4. Mostrar Pedido");
            System.out.println("5. Comprar");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    visualizarProdutos();
                    break;
                case 1:
                    escolherItem(scanner);
                    break;
                case 2:
                    limparPedido();
                    break;
                case 3:
                    depositar(scanner);
                    break;
                case 4:
                    mostrarPedido();
                    break;
                case 5:
                    comprar();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void mostrarPedido() {
        controleCompra.mostrarPedido();
    }

    private void comprar() {
        controleCompra.comprar();
        System.out.println("Compra Realizada com sucesso");
    }

    private void depositar(Scanner scanner) {

        System.out.print("Digite o valor que deseja depositar: ");
        double valor = scanner.nextDouble();

        controleCompra.depositar(valor);

        System.out.println("Valor Depositado com sucesso!");
    }

    private void limparPedido() {
        controleCompra.limparPedido();
    }


    private void escolherItem(Scanner scanner) {
        System.out.print("Digite o ID do produto: ");
        scanner.nextLine();

        String id = scanner.nextLine();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        controleCompra.escolherItem(id, quantidade);
    }

    public void menuEstoque(Scanner scanner) {
        System.out.println("----- Menu de Estoque -----");
        System.out.println("1. Visualizar Produtos");
        System.out.println("2. Adicionar Novo Produto");
        System.out.println("3. Remover Produto");
        System.out.println("4. Alterar Produto");
        System.out.println("5. Voltar");
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
                removerProdutoEstoque(scanner);
                break;
            case 4:
                alterarProduto(scanner);
                break;
            case 5:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void alterarProduto(Scanner scanner) {
        System.out.println("----- Menu de Estoque -----");
        System.out.println("1. Acrescentar quantidade do produto no estoque");
        System.out.println("2. Editar dados do Produto");
        System.out.println("3. Mostrar Produtos");
        System.out.println("4. Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                acrescentarQuantidadeEstoque(scanner);
                break;
            case 2:
                editarProduto(scanner);
                break;
            case 3:
                visualizarProdutos();
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }


    }

    private void editarProduto(Scanner scanner) {
        System.out.print("Digite o ID do produto que deseja editar");
        scanner.nextLine();

        String id = scanner.nextLine();

        Produto produtoAntigo = controleEstoque.buscarProduto(id);

        System.out.print("Digite a nova marca do produto:");

        String marca = scanner.nextLine();

        System.out.print("Digite o novo modelo do produto:");
        String modelo = scanner.nextLine();

        System.out.print("Digite a nova cor do produto:");
        String cor = scanner.nextLine();

        System.out.print("Digite o novo tamanho do produto:");
        String tamanho = scanner.nextLine();

        System.out.print("Digite o novo preço de custo do produto:");
        double precoCusto = scanner.nextDouble();

        System.out.print("Digite o novo preço de venda do produto:");
        double precoVenda = scanner.nextDouble();

        Produto produtoNovo = new Produto(produtoAntigo.getId(), marca, modelo, cor, tamanho, precoCusto, precoVenda, produtoAntigo.getQuantidadeEmEstoque());

        controleEstoque.atualizarProduto(produtoAntigo, produtoNovo);
    }

    private void acrescentarQuantidadeEstoque(Scanner scanner) {
        System.out.print("Digite o ID do produto: ");
        scanner.nextLine();
        String idProduto = scanner.nextLine();
        System.out.print("Digite a quantidade a ser adicionada: ");
        int quantidadeDoProduto = scanner.nextInt();

        if (controleEstoque.acrescentarProdutoNoEstoque(idProduto, quantidadeDoProduto)) {
            System.out.println("Produto Atualizado com sucesso");
        } else {
            System.out.println("Não foi possível atualizar os dados do produto");
        }
    }

    public void menuUsuario(Scanner scanner) {
        System.out.println("----- Menu de Usuário -----");
        System.out.println("1. login");
        System.out.println("2. cadastrar");
        System.out.println("3. deslogar");
        System.out.println("4. voltar");
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
                deslogar();
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void deslogar() {
        controleUsuario.deslogar();
        System.out.println("Deslogado com sucesso");
    }

    private void cadastrarUsuario(Scanner scanner) {

        System.out.println("**Cadastro de Usuário - Login**");
        scanner.nextLine();
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        if (!controleUsuario.verificarEmail(email)) {
            System.out.println("Email já cadastrado");
            return;
        }

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        if (!controleUsuario.validarSenha(senha)) {
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
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Digite seu CPF ou CNPJ: ");
        String cpfOuCnpj = scanner.nextLine();
        Pessoa pessoa;
        if (ValidadorCPFouCNPJ.isCNPJ(cpfOuCnpj)) {
            pessoa = new PessoaJuridica(nome, endereco, cpfOuCnpj, telefone, dataNascimento);
        } else if (ValidadorCPFouCNPJ.isCPF(cpfOuCnpj)) {
            pessoa = new PessoaFisica(nome, endereco, cpfOuCnpj, telefone, dataNascimento);
        } else {
            System.out.println("CPF ou CNPJ inválido");
            return;
        }

        Usuario novoUsuario = new Usuario(email, senha, pessoa);

        controleUsuario.cadastrarUsuario(novoUsuario);
        System.out.println("Cadastro realizado com sucesso!");

    }

    private void logarUsuario(Scanner scanner) {
        System.out.print("Digite seu e-mail: ");
        scanner.nextLine();
        String email = scanner.nextLine();

        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        if (controleUsuario.logar(email, senha)) {
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
        scanner.nextLine();
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

    private void removerProdutoEstoque(Scanner scanner) {
        System.out.println("Digite o ID do produto que deseja remover: ");
        scanner.nextLine();
        String idProduto = scanner.next();
        controleEstoque.removerProduto(idProduto);
    }

}

