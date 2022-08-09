package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entidade.PessoaFisica;
import model.repository.PessoaFisicaRepository;


public class PrincipalConta {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		PessoaFisica titular1 = new PessoaFisica("juca", "12345678900", sdf.parse("24-07-1980"), "M");
		PessoaFisicaRepository pfr = new PessoaFisicaRepository();
		pfr.inserirPessoaFisica(titular1);
		
		System.out.println(pfr.listarPessoaFisica());
		
		System.out.println();
		
		System.out.println(pfr.consultarPessoaFisica(2));
		
		
		
//		Conta conta1 = new Conta("123-7", "12345-6", 600.0);
//		Conta conta2 = new Conta("123-7", "9876-5", -600.0);
//		Conta conta3 = new Conta("123-7", "6543-2", -1200.0);
//		Conta conta4 = new Conta("123-7", "7878-9", 500.0);
//		Conta conta5 = new Conta("123-7", "7979-0", -1200.0);
//		Conta conta6 = new Conta("123-7", "7777-8", 300.0);
//		
////		Pessoa titular1 = new PessoaFisica("Joao", true, "24/07/1980", "123456789-00", 'm');
////		Pessoa titular2 = new PessoaJuridica("Empresa XYZ Ltda", false, "22333444000199", "19/11/2001");
//		
//		ArrayList <Conta> contas = new ArrayList();
//		contas.add(conta1);
//		contas.add(conta2);
//		contas.add(conta3);
//		
////		titular1.setContas(contas);
//		
//		ArrayList <Conta> contasPj = new ArrayList();
//		contasPj.add(conta4);
//		contasPj.add(conta5);
//		contasPj.add(conta6);
//		
////		titular2.setContas(contasPj);
//		
////		joao.verificarAdimplencia();
////		System.out.println("O Cliente " + titular1.getNome() + " e titular das contas: ");
////		for (int i = 0; i < contas.size(); i++) {
////			System.out.println(contas.get(i));
////		}
////		System.out.println("Cliente " + titular1.getNome() + " esta adimplente: " + titular1.verificarAdimplencia());
////		System.out.println("");
////		System.out.println("O Cliente " + titular2.getNome() + " e titular das contas: ");
////		for (int i = 0; i < contasPj.size(); i++) {
////			System.out.println(contasPj.get(i));
////		}
////		System.out.println("Cliente " + titular2.getNome() + " esta adimplente: " + titular2.verificarAdimplencia());
////		
////		
////		System.out.println("Agencia: " + conta1.getNumeroAgencia() + " Conta: " + conta1.getNumeroConta());
////		System.out.println("");
////		
////		System.out.println("Saldo Atual: R$" + conta1.getSaldo());
////		System.out.println("Valor Sacado: R$" + conta1.sacarValor(250.0));
////		System.out.println("Saldo Atualizado: R$" + conta1.getSaldo());
////		System.out.println("");
////		System.out.println("Valor Sacado: R$" + conta1.sacarValor(300.0));
////		System.out.println("Saldo Atualizado: R$" + conta1.getSaldo());
////		System.out.println("");
////		System.out.println("Valor Depositado: R$ " + conta1.depositarValor(200.0));
////		System.out.println("Saldo Atualizado: R$ " + conta1.getSaldo());
////		System.out.println("");
////		System.out.println("Rendimento Recebido: R$ " + conta1.efetuarRendimento(0.5));
////		System.out.println("Saldo Atualizado: R$ " + conta1.getSaldo());
////		System.out.println("");
////		System.out.println("Rendimento Recebido: R$ " + conta1.efetuarRendimento(0.8));
////		System.out.println("Saldo Atualizado: R$ " + conta1.getSaldo());
////		
		
	}

}
