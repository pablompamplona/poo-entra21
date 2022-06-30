package entidade;

public class Gerente extends Funcionario {
	
	private String setor;

	public Gerente(String nome, double salario, String setor) {
		super(nome, salario);
		this.setor = setor;
	}

	@Override
	public double calcularSalarioLiquido() {
		return super.calcularSalarioLiquido() + calcularComissao() + calcularGratificacao();
		
	}
	public double calcularComissao() {
		return this.getSalario() * 0.15;
	}
	public double calcularGratificacao() {
		this.setor.toUpperCase();
		if (this.setor.equals("TI")) {
			return 500.00;
		} else {
			return 0.00;
		}
		
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
		
	
	
	

}
