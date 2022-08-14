package model.entidade;

import model.entidade.enums.TipoConta;

public class ContaJuridica extends Conta {
	
	private PessoaJuridica titular;

	
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
	
	@Override
	public String toString() {
		return "Agencia: " + getNumeroAgencia() + "\n" +
				"Conta: " + getNumeroConta() + "\n" +
				"Tipo: " + getTipo() + "\n" +
				"Titular: " + titular;
 	}
	

}
