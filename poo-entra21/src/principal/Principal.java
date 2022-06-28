package principal;

import entidade.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		Pessoa pedro = new Pessoa("Pedro de Lara", "123.456.789-00");
		pedro.setDataNascimento("15/08/2002");
		
		System.out.println("Nome: " + pedro.getNome());
		System.out.println("Idade: " + pedro.calcularIdade(2022));

		
	}

}
