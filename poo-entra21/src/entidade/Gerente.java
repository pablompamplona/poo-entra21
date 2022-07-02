package entidade;

public class Gerente extends Funcionario {
	
	public double calcularComissao() {
//		double comissaoVendas = this.getSalarioBruto() * 0.15;
		double comissaoVendas = 520.0;
		return comissaoVendas;
	}
	@Override
	public double calcularSalarioLiquido() {
		double salarioLiquido = super.calcularSalarioLiquido() + calcularComissao();
		return salarioLiquido;
		
	}
	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gerente(String nome, String dataNascimento, double salarioBruto, String cpf, String dataAdmissao) {
		super(nome, dataNascimento, salarioBruto, cpf, dataAdmissao);
		// TODO Auto-generated constructor stub
	}
	
}
