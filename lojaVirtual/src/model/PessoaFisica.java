package model;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa {

	private String cpf;
	

	public PessoaFisica(String nome, String endereco, String cpf, String telefone, LocalDate datadenascimento) {
		super(nome, endereco, telefone, datadenascimento);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "\n cpf= " + cpf + "\n nome= " + getNome()
				+ "\n Endereço= " + getEndereco() + "\n Telefone= " + getTelefone() + "\n Data de Nascimento= "
				+ getDatadenascimento() + "\n Saldo= " + getSaldo();
	}


}
