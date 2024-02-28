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
		return "PessoaFisica [cpf=" + cpf + ", getNome()=" + getNome()
				+ ", getEndereco()=" + getEndereco() + ", getTelefone()=" + getTelefone() + ", getDatadenascimento()="
				+ getDatadenascimento() + ", getSaldo()=" + getSaldo() + "]";
	}


}
