package principal;

import java.util.ArrayList;

import entidade.Funcionario;
import entidade.Gerente;
import entidade.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		Funcionario gerenteRh = new Gerente("Joao", 1000, "RH");
		Funcionario funcionarioPedro = new Funcionario("Pedro", 1000);
		Funcionario gerenteTi = new Gerente("Luciano", 3000, "TI");
		
		ArrayList<Funcionario> empregados = new ArrayList <>();
		
		empregados.add(gerenteRh);
		empregados.add(funcionarioPedro);
		empregados.add(gerenteTi);
		
		double totalFolha = 0;
		
		for (int i = 0; i < empregados.size(); i++) {
			Funcionario funcionarioAtual = empregados.get(i);
			System.out.println("Nome Funcionario: " + funcionarioAtual.getNome() + "  /  Valor Salario: R$ " + funcionarioAtual.calcularSalarioLiquido());
			totalFolha += funcionarioAtual.calcularSalarioLiquido();
		}
		
		System.out.println("");
		System.out.println("Total Folha de Pagamento : R$ " + totalFolha);
		
		
	
		
	}

}
