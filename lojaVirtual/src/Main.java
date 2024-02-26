import controller.ControleCompra;
import controller.ControleEstoque;
import controller.ControleUsuario;
import view.View;

public class Main {
    public static void main(String[] args) {
        // Criar instâncias das classes necessárias
       
        ControleCompra controleCompra = new ControleCompra();
        ControleUsuario controleUsuario = new ControleUsuario();
        ControleEstoque controleEstoque = new ControleEstoque();

        // Configurar as instâncias na View
        View view = new View();
       
        view.setControleCompra(controleCompra);
        view.setControleUsuario(controleUsuario);
        view.setControleEstoque(controleEstoque);

        // Rodar o menu principal
        view.menuPrincipal();
    }
}