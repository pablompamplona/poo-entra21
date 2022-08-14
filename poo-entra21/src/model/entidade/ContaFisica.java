package model.entidade;

import model.entidade.enums.TipoConta;

public class ContaFisica extends Conta{
	
	private int idContaFisica;
	private PessoaFisica titular;
	private int idTitular;
	
	

	public ContaFisica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ContaFisica(String numeroAgencia, String numeroConta, TipoConta tipo) {
		super(numeroAgencia, numeroConta, tipo);
		
	}

	public ContaFisica(String numeroAgencia, String numeroConta, TipoConta tipo, PessoaFisica titular) {
		super(numeroAgencia, numeroConta, tipo);
		this.titular = titular;
	}

	public int getIdContaFisica() {
		return idContaFisica;
	}

	public void setIdContaFisica(int idContaFisica) {
		this.idContaFisica = idContaFisica;
	}

	public PessoaFisica getTitular() {
		return titular;
	}

	public void setTitular(PessoaFisica titular) {
		this.titular = titular;
	}
	
	public int getIdTitular() {
		return idTitular;
	}

	public void setIdTitular(int idTitular) {
		this.idTitular = idTitular;
	}

	@Override
	public String toString() {
		return "Agencia: " + getNumeroAgencia() + "\n" +
				"Conta: " + getNumeroConta() + "\n" +
				"Tipo: " + getTipo() + "\n" +
				"Titular: " + titular;
 	}

	public void setTipo(String string) {
		super.setTipo(TipoConta.valueOf(string));
	}
	
	public void setTitular(int id) {
		
	}
}
