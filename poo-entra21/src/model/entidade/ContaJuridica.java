package model.entidade;

import model.entidade.enums.TipoConta;

public class ContaJuridica extends Conta {
	
	private int idContaJuridica;
	private PessoaJuridica titular;
	private int idTitular;

	
	public ContaJuridica() {
		super();
	}

	public ContaJuridica(String numeroAgencia, String numeroConta, TipoConta tipo) {
		super(numeroAgencia, numeroConta, tipo);
	}

	public ContaJuridica(String numeroAgencia, String numeroConta, TipoConta tipo, PessoaJuridica titular) {
		super(numeroAgencia, numeroConta, tipo);
		this.titular = titular;
	}

	public PessoaJuridica getTitular() {
		return titular;
	}

	public void setTitular(PessoaJuridica titular) {
		this.titular = titular;
	}
	
	public int getIdContaJuridica() {
		return idContaJuridica;
	}

	public void setIdContaJuridica(int idContaJuridica) {
		this.idContaJuridica = idContaJuridica;
	}

	public int getIdTitular() {
		return idTitular;
	}

	public void setIdTitular(int idTitular) {
		this.idTitular = idTitular;
	}

	@Override
	public String toString() {
		return "ID: " + idContaJuridica + "\n" +
				"Agencia: " + getNumeroAgencia() + "\n" +
				"Conta: " + getNumeroConta() + "\n" +
				"Tipo: " + getTipo() + "\n" +
				"Titular: " + titular;
 	}
	

}
