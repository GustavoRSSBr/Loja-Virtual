package model;

public class Usuario {

    private String email;
    private String senha;
    private Pessoa pessoa;

    public Usuario(String email, String senha, Pessoa pessoa) {
        this.email = email;
        this.senha = senha;
        this.pessoa = pessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
