import controller.ControleCompra;
import controller.ControleEstoque;
import controller.ControleUsuario;
import view.View;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        // Criar instâncias das classes necessárias
        ControleUsuario controleUsuario = new ControleUsuario();
        ControleEstoque controleEstoque = new ControleEstoque();
        ControleCompra controleCompra = new ControleCompra(controleEstoque, controleUsuario);

        // Configurar as instâncias na View
        View view = new View();
        view.setControleCompra(controleCompra);
        view.setControleUsuario(controleUsuario);
        view.setControleEstoque(controleEstoque);

        // Rodar o menu principal
        try {
            view.menuPrincipal();
        } catch (InputMismatchException e) {
            System.out.println("Erro na entrada de dados. Digite um número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado. Tente novamente mais tarde.");
            e.printStackTrace();
        }


    }
}