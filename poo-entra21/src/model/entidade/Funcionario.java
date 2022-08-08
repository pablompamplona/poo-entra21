package model.entidade;

public class Funcionario {
	
	private String nome;
	private String dataNascimento;
	private double salarioBruto;
	private String cpf;
	private String dataAdmissao;
	private Endereco endereco;
	
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome, String dataNascimento, double salarioBruto, String cpf, String dataAdmissao,
			Endereco endereco) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salarioBruto = salarioBruto;
		this.cpf = cpf;
		this.dataAdmissao = dataAdmissao;
		this.endereco = endereco;
	}

	public double calcularSalarioLiquido() {
		double salarioLiquido = 0.0;
		salarioLiquido = this.getSalarioBruto() - calcularDesconto(); 
		return salarioLiquido;
	}
	
	public double calcularDesconto() {
		double descontosLegais = 0.0;
		descontosLegais = this.getSalarioBruto() * 0.06;
		return descontosLegais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nData Nascto: " + dataNascimento + "\nCPF:" + cpf + 
				"\nEnd: " + endereco + "\nData Admissao: " + dataAdmissao + "\nSalario Base: " + salarioBruto;
	}

	
}