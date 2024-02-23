package model;

import java.time.LocalDate;

class PessoaJuridica extends Pessoa {
    private String cnpj;
   
   
    public PessoaJuridica(String nome, String endereco, String cnpj, String telefone, 
    		LocalDate datadenascimento, double saldo) {
    	super(nome, endereco, telefone, datadenascimento,saldo );
		
        this.cnpj = cnpj;
       
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj  + ", getNome()=" + getNome()
				+ ", getEndereco()=" + getEndereco() + ", getTelefone()=" + getTelefone() + ", getDatadenascimento()="
				+ getDatadenascimento() + ", getSaldo()=" + getSaldo() + "]";
	}

	public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

	
}



