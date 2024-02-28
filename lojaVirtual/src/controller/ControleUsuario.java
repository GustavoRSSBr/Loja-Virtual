package controller;

import model.Pessoa;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ControleUsuario {
    private static final String REGEX_SENHA = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    private Usuario usuarioLogado;
    public List<Usuario> listaDeUsuarios = new ArrayList<>();

    private final String emailADM = "admin@email.com";
    private final String senhaADM = "Admin#123";
    private String permissao = "DESLOGADO";

    public ControleUsuario() {
        listaDeUsuarios.add(new Usuario(emailADM, senhaADM, new Pessoa()));
    }

    public boolean validarSenha(String senha) {
        Pattern pattern = Pattern.compile(REGEX_SENHA);
        return pattern.matcher(senha).matches();
    }


    public boolean logar(String email, String senha) {
        for (Usuario usuario : this.listaDeUsuarios) {
            if (email.equals(emailADM) && senha.equals(senhaADM)) {
                if (usuario.getEmail().equals(emailADM) && usuario.getSenha().equals(senhaADM)) {
                    usuarioLogado = usuario;
                    permissao = "ADM";
                    return true;
                }

            } else if (email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
                usuarioLogado = usuario;
                permissao = "CLIENTE";
                return true;
            }
        }
        return false;
    }

    public void deslogar() {
        usuarioLogado = null;
        permissao = "DESLOGADO";
    }

    public boolean verificarEmail(String email) {
        for (Usuario usuario : this.listaDeUsuarios) {
            if (usuario.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public void cadastrarUsuario(Usuario usuario) {
        this.listaDeUsuarios.add(usuario);
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public String getPermissao() {
        return permissao;
    }

}
