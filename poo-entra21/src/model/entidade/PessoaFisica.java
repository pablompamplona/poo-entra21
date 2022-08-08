package model.entidade;

import java.util.ArrayList;

public class PessoaFisica extends Pessoa {
	

	private String dataNascimento;
	private String cpf;
	private char sexo;
	
			
	//Construtores
	public PessoaFisica() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public PessoaFisica(String nome, boolean adimplente, String dataNascimento, String cpf, char sexo) {
		super(nome, adimplente);
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
	}


	public boolean verificarAdimplencia() {
		double saldoGeral = 0;
		for (int i = 0; i < super.getContas().size(); i++) {
			saldoGeral += super.getContas().get(i).getSaldo();
		}
		if (saldoGeral < (-500.0)) {
			super.setAdimplente(false);	
		}else {
			super.setAdimplente(true);
		}
		return super.isAdimplente();
	}

	public int calcularIdade(int anoAtual) {
		int idade = 0;
		//Assumir dd/MM/yyyy
		String anoNascimento = this.dataNascimento.substring(6);
		idade = anoAtual - Integer.valueOf(anoNascimento);
		
		return idade;
	}
	
	//getters and Setters

	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	

}
