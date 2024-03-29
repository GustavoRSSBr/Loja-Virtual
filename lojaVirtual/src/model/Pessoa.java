package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	private String nome;
	private String endereco;
	private String telefone;
	private LocalDate datadenascimento;
	private double saldo;

	public Pessoa(String nome, String endereco, String telefone, 
			LocalDate datadenascimento) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.datadenascimento = datadenascimento;
		this.saldo = 100.0;
	}

	public Pessoa(){
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDatadenascimento() {
		return this.datadenascimento;
	}

	public void setDatadenascimento(LocalDate datadenascimento) {
		this.datadenascimento = datadenascimento;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
