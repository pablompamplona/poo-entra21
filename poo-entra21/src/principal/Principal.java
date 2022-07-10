package principal;

import java.util.ArrayList;
import java.util.Iterator;

import entidade.ChefeDeSecao;
import entidade.Diretor;
import entidade.Endereco;
import entidade.Funcionario;
import entidade.Gerente;
import entidade.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		Endereco endereco1 = new Endereco ("88010-000","Rua dos Pescador","120","Barra da Lagoa","florianoplix","SC");
		Funcionario funcionario1 = new Funcionario("Joao JC", "15/01/1990", 2500.0, "123456789-00","10/01/2017",endereco1);
		Endereco endereco2 = new Endereco ("88095-050","Serv Julio de Oliveira","213","Coloninha","Floripa","SC");
		Funcionario funcionario2 = new Funcionario("Gustavo Coloninha", "10/01/1992", 2500.0, "123456789-00", "15/10/2015", endereco2);
		Endereco endereco3 = new Endereco ("88095-060","Rua Otilia Cruz","666","Coloninha","Florianopolis", "SC");
		Funcionario funcionario3 = new Funcionario("Dago Palhocinha", "03/05/1998", 2500.0, "123456789-00", "30/08/2018", endereco3);
		Endereco endereco4 = new Endereco ("88025-210","Rua Antonio Carlos Ferreira","196","Agronomica","Florianopolis","SC");
		Funcionario funcionario4 = new ChefeDeSecao("Rafa do Horacio", "24/07/1989", 2500.0, "123456789-00", "20/08/2009", endereco4);
		Endereco endereco5 = new Endereco ("88034-020","Rua Acelon Pacheco da Costa", "295", "Itacorubi","Floripa dos Boy","SC");
		Funcionario funcionario5 = new ChefeDeSecao("Lucia Louca", "19/09/1967", 2500.0, "123456789-00", "20/05/2002", endereco5);
		Endereco endereco6 = new Endereco ("88095-000","Av Marinheiro Max Schramm", "2428", "Estreito","Floripa","SC");
		Funcionario funcionario6 = new Gerente("Pablo Pamplona", "24/07/1980", 4000.0, "123456789-00", "15/01/2000", endereco6);
		Endereco endereco7 = new Endereco ("SIGILO","Rua Secreta","S/N","Centro","Floripa","SC");
		Funcionario funcionario7 = new Diretor("Vilmar Professor", "15/01/1990", 12000.0, "123456789-00", "01/05/2007", endereco7);
						
		ArrayList<Funcionario> empregados = new ArrayList <>();
		empregados.add(funcionario1);
		empregados.add(funcionario2);
		empregados.add(funcionario3);
		empregados.add(funcionario4);
		empregados.add(funcionario5);
		empregados.add(funcionario6);
		empregados.add(funcionario7);
			
		double totalFolha = 0, totalFolhaGerente = 0, totalFolhaChefia = 0, totalFolhaDiretoria = 0;
		
		for (int i = 0; i < empregados.size(); i++) {
			Funcionario funcionarioAtual = empregados.get(i);
			totalFolha += funcionarioAtual.calcularSalarioLiquido();
			if (funcionarioAtual instanceof Gerente) {
				totalFolhaGerente += funcionarioAtual.calcularSalarioLiquido();
			} else if (funcionarioAtual instanceof ChefeDeSecao) {
				totalFolhaChefia += funcionarioAtual.calcularSalarioLiquido();
			} else if (funcionarioAtual instanceof Diretor) {
				totalFolhaDiretoria += funcionarioAtual.calcularSalarioLiquido();
			}
		}
				
		System.out.println("****** RELACAO DE FUNCIONARIOS ******");
		for (int i = 0; i < empregados.size(); i++) {
			System.out.println(" ");
			System.out.println(empregados.get(i));
			System.out.println(" ");
			System.out.println("*************************************");
		}
		System.out.println("");
		System.out.println("Total Folha de Pagamento Chefia :    R$ " + totalFolhaChefia);
		System.out.println("Total Folha de Pagamento Gerencia :  R$ " + totalFolhaGerente);
		System.out.println("Total Folha de Pagamento Direcao :  R$ " + totalFolhaDiretoria);
		System.out.println("");
		System.out.println("Total Geral da Folha de Pagamento : R$ " + totalFolha);
		
		
	}

}
