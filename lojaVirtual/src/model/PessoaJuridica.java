package model;

import java.time.LocalDate;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
   
   
    public PessoaJuridica(String nome, String endereco, String cnpj, String telefone, 
    		LocalDate datadenascimento) {
    	super(nome, endereco, telefone, datadenascimento);
        this.cnpj = cnpj;
       
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
	public String toString() {
		return "\n cnpj= " + cnpj + "\n nome= " + getNome()
		+ "\n Endereço= " + getEndereco() + "\n Telefone= " + getTelefone() + "\n Data de Nascimento="
		+ getDatadenascimento() + "\n Saldo= " + getSaldo();
	}

	public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}



