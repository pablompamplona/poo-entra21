package entidade;

public class ChefeDeSecao extends Funcionario{
	
	public ChefeDeSecao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChefeDeSecao(String nome, String dataNascimento, double salarioBruto, String cpf, String dataAdmissao,
			Endereco endereco) {
		super(nome, dataNascimento, salarioBruto, cpf, dataAdmissao, endereco);
		// TODO Auto-generated constructor stub
	}

	public double calcularAdicionalChefia() {
		double adicionalChefia = 300.0;
		return adicionalChefia;
	}
	
	public double calcularSalarioLiquido() {
		double salarioLiquido = super.calcularSalarioLiquido() + calcularAdicionalChefia();
		return salarioLiquido;
	}
}
