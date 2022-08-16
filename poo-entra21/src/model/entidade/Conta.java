package model.entidade;

import java.util.Scanner;

import model.entidade.enums.TipoConta;

public abstract class Conta {
	
	private String numeroAgencia;
	private String numeroConta;
	private TipoConta tipo;
	private double saldo;
	
	

	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Conta(String numeroAgencia, String numeroConta, TipoConta tipo) {
		super();
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.tipo = tipo;
		
	}

//	public void cadastrarConta() {
//		Scanner input = new Scanner(System.in);
//		this.numeroAgencia = "123-7";
//		System.out.println("Informe numero da conta: ");
//		this.numeroConta = input.nextLine();
//		System.out.println("Informe o valor do deposito de abertura: ");
//		this.saldo = input.nextDouble();
//	}
	
	public double sacarValor(double valorSaque) {
		double valorSacado = 0;
//		if (valorSaque <= this.saldo) {
//			this.saldo -= valorSaque;
//			valorSacado = valorSaque;
//			}  else {
//				valorSaque = this.saldo;
//				this.saldo -= this.saldo;
//				valorSacado = valorSaque;
//			}
		this.saldo -= valorSaque;
		valorSacado = valorSaque;
			return valorSacado;
		}
	
	public double depositarValor(double valorDeposito) {
		double valorDepositado = 0;
		this.saldo += valorDeposito;
		valorDepositado = valorDeposito;
		return valorDepositado;
	}
	
	public double efetuarRendimento (double indiceRentabilidade) {
		double rendimento = 0;
		rendimento = this.saldo * (indiceRentabilidade/100);
		this.saldo += rendimento;
		return rendimento;
	} 
		
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public TipoConta getTipo() {
		return tipo;
	}



	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}



	@Override
	public String toString() {
		return "Agencia: " + numeroAgencia + " Conta: " + numeroConta;
	}

		
	
}
