package entidade;

public class Diretor extends Funcionario {
	
	public Diretor() {
		super();
		
	}
		
	public Diretor(String nome, String dataNascimento, double salarioBruto, String cpf, String dataAdmissao,
			Endereco endereco) {
		super(nome, dataNascimento, salarioBruto, cpf, dataAdmissao, endereco);
		// TODO Auto-generated constructor stub
	}



	public double calcularAdicionalTempoServico () {
		double adicionalTempoServico = 0;
		int anoAtual = 2022;
		double indiceGratificacao = 0.05;
		String buscaAno = super.getDataAdmissao().substring(6);
		int anoAdmissao = Integer.parseInt(buscaAno);
		int tempoServiço = (anoAtual - anoAdmissao)/3;
		adicionalTempoServico = super.getSalarioBruto() * (indiceGratificacao * tempoServiço);
		return adicionalTempoServico;
	}
	@Override
	public double calcularSalarioLiquido( ) {
		double salarioLiquido = super.calcularSalarioLiquido() + calcularAdicionalTempoServico();
		return salarioLiquido;
	}

}
