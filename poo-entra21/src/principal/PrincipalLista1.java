package principal;

import java.util.ArrayList;

import entidade.ContaLista1;
import entidade.PessoaFisicaLista1;
import entidade.PessoaJuridicaLista1;
import entidade.PessoaLista1;

public class PrincipalLista1 {

	public static void main(String[] args) {
		
		ContaLista1 conta1 = new ContaLista1("123-7", "12345-6", 600.0);
		ContaLista1 conta2 = new ContaLista1("123-7", "9876-5", -600.0);
		ContaLista1 conta3 = new ContaLista1("123-7", "6543-2", -1200.0);
		ContaLista1 conta4 = new ContaLista1("123-7", "7878-9", 500.0);
		ContaLista1 conta5 = new ContaLista1("123-7", "7979-0", -1200.0);
		ContaLista1 conta6 = new ContaLista1("123-7", "7777-8", 300.0);
		
		PessoaLista1 titular1 = new PessoaFisicaLista1("Joao", true, "24/07/1980", "123456789-00", 'm');
		PessoaLista1 titular2 = new PessoaJuridicaLista1("Empresa XYZ Ltda", false, "22333444000199", "19/11/2001");
		
		ArrayList <ContaLista1> contas = new ArrayList();
		contas.add(conta1);
		contas.add(conta2);
		contas.add(conta3);
		
		titular1.setContas(contas);
		
		ArrayList <ContaLista1> contasPj = new ArrayList();
		contasPj.add(conta4);
		contasPj.add(conta5);
		contasPj.add(conta6);
		
		titular2.setContas(contasPj);
		
//		joao.verificarAdimplencia();
		System.out.println("O Cliente " + titular1.getNome() + " e titular das contas: ");
		for (int i = 0; i < contas.size(); i++) {
			System.out.println(contas.get(i));
		}
		System.out.println("Cliente " + titular1.getNome() + " esta adimplente: " + titular1.verificarAdimplencia());
		System.out.println("");
		System.out.println("O Cliente " + titular2.getNome() + " e titular das contas: ");
		for (int i = 0; i < contasPj.size(); i++) {
			System.out.println(contasPj.get(i));
		}
		System.out.println("Cliente " + titular2.getNome() + " esta adimplente: " + titular2.verificarAdimplencia());
		
		
//		System.out.println("Agencia: " + conta1.getNumeroAgencia() + " Conta: " + conta1.getNumeroConta());
//		System.out.println("");
//		
//		System.out.println("Saldo Atual: R$" + conta1.getSaldo());
//		System.out.println("Valor Sacado: R$" + conta1.sacarValor(250.0));
//		System.out.println("Saldo Atualizado: R$" + conta1.getSaldo());
//		System.out.println("");
//		System.out.println("Valor Sacado: R$" + conta1.sacarValor(300.0));
//		System.out.println("Saldo Atualizado: R$" + conta1.getSaldo());
//		System.out.println("");
//		System.out.println("Valor Depositado: R$ " + conta1.depositarValor(200.0));
//		System.out.println("Saldo Atualizado: R$ " + conta1.getSaldo());
//		System.out.println("");
//		System.out.println("Rendimento Recebido: R$ " + conta1.efetuarRendimento(0.5));
//		System.out.println("Saldo Atualizado: R$ " + conta1.getSaldo());
//		System.out.println("");
//		System.out.println("Rendimento Recebido: R$ " + conta1.efetuarRendimento(0.8));
//		System.out.println("Saldo Atualizado: R$ " + conta1.getSaldo());
//		
		
	}

}
