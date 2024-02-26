package controller;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ControleUsuario {
    private static final String REGEX_SENHA = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    private Usuario usuarioLogado;
    public List<Usuario> listaDeUsuarios = new ArrayList<>();

    public boolean validarSenha(String senha) {
        Pattern pattern = Pattern.compile(REGEX_SENHA);
        return pattern.matcher(senha).matches();
    }



    public boolean logar(String email, String senha){
        for (Usuario usuario : this.listaDeUsuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                return true;
            }
        }
        return false;
    }

    public void deslogar(){
        usuarioLogado = null;
    }

    public boolean verificarEmail(String email) {
        for (Usuario usuario : this.listaDeUsuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void cadastrarUsuario(Usuario usuario) {
        this.listaDeUsuarios.add(usuario);
    }
}
