package entidade;

public class Gerente extends Funcionario {
	
	public static final double COMISSAO = 520.0;
	
	
	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gerente(String nome, String dataNascimento, double salarioBruto, String cpf, String dataAdmissao,
			Endereco endereco) {
		super(nome, dataNascimento, salarioBruto, cpf, dataAdmissao, endereco);
		// TODO Auto-generated constructor stub
	}
	
	public double calcularComissao() {
		double comissaoVendas = COMISSAO;
		return comissaoVendas;
	}
	@Override
	public double calcularSalarioLiquido() {
		double salarioLiquido = super.calcularSalarioLiquido() + calcularComissao();
		return salarioLiquido;
		
	}
	
}
