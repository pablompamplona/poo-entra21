package entidade;

public class ContaLista1 {
	
	private String numeroAgencia;
	private String numeroConta;
	private double saldo;
	
	
	public ContaLista1() {
		super();
		
	}

	public ContaLista1(String numeroAgencia, String numeroConta, double saldo) {
		super();
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	public double sacarValor(double valorSaque) {
		double valorSacado = 0;
		if (valorSaque <= this.saldo) {
			this.saldo -= valorSaque;
			valorSacado = valorSaque;
			}  else {
				valorSaque = this.saldo;
				this.saldo -= this.saldo;
				valorSacado = valorSaque;
			}
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

		
	
}
