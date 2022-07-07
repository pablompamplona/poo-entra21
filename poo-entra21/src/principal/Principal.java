package principal;

import java.util.ArrayList;

import entidade.ChefeDeSecao;
import entidade.Diretor;
import entidade.Funcionario;
import entidade.Gerente;
import entidade.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		
		Funcionario funcionario1 = new Funcionario("Joao JC", "15/01/1990", 2500.0, "123456789-00","10/01/2017");
		Funcionario funcionario2 = new Funcionario("Gustavo Coloninha", "10/01/1992", 2500.0, "123456789-00", "15/10/2015");
		Funcionario funcionario3 = new Funcionario("Dago Palhocinha", "03/05/1998", 2500.0, "123456789-00", "30/08/2018");
		Funcionario funcionario4 = new ChefeDeSecao("Rafa do Vintecinco", "24/07/1989", 2500.0, "123456789-00", "20/08/2009");
		Funcionario funcionario5 = new ChefeDeSecao("Lucia Louca", "19/09/1967", 2500.0, "123456789-00", "20/05/2002");
		Funcionario funcionario6 = new Gerente("Pablo Pamplona", "24/07/1980", 4000.0, "123456789-00", "15/01/2000");
		Funcionario funcionario7 = new Diretor("Vilmar Professor", "15/01/1990", 12000.0, "123456789-00", "01/05/2007");
				
				
		ArrayList<Funcionario> empregados = new ArrayList <>();
		
		empregados.add(funcionario1);
		empregados.add(funcionario2);
		empregados.add(funcionario3);
		empregados.add(funcionario4);
		empregados.add(funcionario5);
		empregados.add(funcionario6);
		empregados.add(funcionario7);
		
	
		double totalFolha = 0, totalFolhaGerente = 0;
		
		for (int i = 0; i < empregados.size(); i++) {
			Funcionario funcionarioAtual = empregados.get(i);
			System.out.println("Nome Funcionario: " + funcionarioAtual.getNome() + "  /  Valor Salario: R$ " + funcionarioAtual.calcularSalarioLiquido());
			totalFolha += funcionarioAtual.calcularSalarioLiquido();
			if (funcionarioAtual instanceof Gerente) {
				totalFolhaGerente += funcionarioAtual.calcularSalarioLiquido();
			}
		}
		
		System.out.println("");
		System.out.println("Total Folha de Pagamento : R$ " + totalFolha);
		System.out.println("Total Folha de Pagamento dos Gerentes : R$ " + totalFolhaGerente);
		
	
		
	}

}
