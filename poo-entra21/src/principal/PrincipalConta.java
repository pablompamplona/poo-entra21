package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entidade.ContaFisica;
import model.entidade.ContaJuridica;
import model.entidade.PessoaFisica;
import model.entidade.PessoaJuridica;
import model.entidade.enums.TipoConta;
import model.repository.ContaFisicaRepository;
import model.repository.ContaJuridicaRepository;
import model.repository.PessoaFisicaRepository;
import model.repository.PessoaJuridicaRepository;


public class PrincipalConta {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner input = new Scanner(System.in);
		PessoaFisica titular1 = new PessoaFisica("matheus", "59989023500", sdf.parse("25-07-1990"), "M");
		PessoaJuridica empresa1 = new PessoaJuridica("lanchonete pao com ovo", "98765432000300", sdf.parse("15-08-2010"));
		PessoaFisicaRepository pfr = new PessoaFisicaRepository();
		PessoaJuridicaRepository pjr = new PessoaJuridicaRepository();
		ContaFisicaRepository cfr = new ContaFisicaRepository();
		ContaFisica conta1 = new ContaFisica("123-4", "5004-1", TipoConta.FISICA, titular1);
		ContaJuridicaRepository cjr = new ContaJuridicaRepository();
		ContaJuridica conta2 = new ContaJuridica("123-4", "10002-0", TipoConta.JURIDICA, empresa1);
		

		
		/* INSERIR PESSOA FISICA E JURIDICA
		 */
//		System.out.println(pfr.inserirPessoaFisica(titular1));
//		
		System.out.println(pjr.inserirPessoaJuridica(empresa1));
		
		
		/* LISTAR PESSOAS FISICAS E JURIDICAS  
		 */
//		System.out.println(pfr.listarPessoaFisica());
//		System.out.println();
//		System.out.println(pjr.listarPessoaJuridica());
		
		/* CONSULTAR PESSOAS FISICAS E JURIDICAS POR ID
		 */
//		System.out.print("id para consulta: ");
//		int id = input.nextInt();
//		System.out.println(pfr.consultarPessoaFisica(id));
//		System.out.print("id para consulta: ");
//		id = input.nextInt();
//		System.out.println(pjr.consultarPessoaJuridica(1));
//		
		/* ALTERAR PESSOA FISICA E JURIDICA
		 */
//		System.out.println(pjr.alterarPessoaJuridica(empresa1, 1));
//		System.out.println();
//		System.out.println(pfr.alterarPessoaFisica(titular1, 1));

		/* EXCLUIR PESSOA FISICA E JURIDICA
		 */
//		System.out.print("id para excluir: ");
//		int id = input.nextInt();
//		System.out.println(pfr.excluirPessoaFisica(id));
//		System.out.print("id para excluir: ");
//		id = input.nextInt();
//		System.out.println(pjr.excluirPessoaJuridica(id));

		
		/* INSERIR CONTA FISICA E JURIDICA
		 */
//		System.out.println(cfr.inserirContaFisica(conta1));
//		System.out.println(cjr.inserirContaJuridica(conta2));
		
		
		/* LISTAR CONTAS FISICAS
		 */
//		System.out.println(cfr.listarContasFisicas());
//		System.out.println(cjr.listarContasJuridicas());
		
		/* CONSULTAR PESSOAS FISICAS E JURIDICAS POR ID
		 */
//		System.out.println(cfr.consultarContaFisica(1));
//		System.out.println(cjr.consultarContaJuridica(2));
		
		
		/* EXCLUIR CONTA FISICA
		 */
//		System.out.println(cfr.excluirContaFisica(2));
//		System.out.println(cjr.excluirContaJuridica(1));
		
		
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
