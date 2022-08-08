package model.entidade;

import java.util.Scanner;

public class Conta {
	
	private String numeroAgencia;
	private String numeroConta;
	private double saldo;
	
	
	public Conta() {
		super();
		
	}

	public Conta(String numeroAgencia, String numeroConta, double saldo) {
		super();
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	public void cadastrarConta() {
		Scanner input = new Scanner(System.in);
		this.numeroAgencia = "123-7";
		System.out.println("Informe numero da conta: ");
		this.numeroConta = input.nextLine();
		System.out.println("Informe o valor do deposito de abertura: ");
		this.saldo = input.nextDouble();
	}
	
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

	@Override
	public String toString() {
		return "Agencia: " + numeroAgencia + " Conta: " + numeroConta;
	}

		
	
}
