package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import controller.ContaFisicaController;
import model.entidade.Conta;
import model.entidade.ContaFisica;
import model.entidade.ContaJuridica;
import model.entidade.PessoaFisica;
import model.entidade.PessoaJuridica;
import model.entidade.enums.TipoConta;
import model.repository.ContaFisicaRepository;
import model.repository.ContaJuridicaRepository;
import model.repository.PessoaFisicaRepository;
import model.repository.PessoaJuridicaRepository;

@SpringBootApplication
@ComponentScan(basePackageClasses = ContaFisicaController.class)
public class PrincipalConta {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(PrincipalConta.class, args);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner input = new Scanner(System.in);
		PessoaFisica titular1 = new PessoaFisica("matheus", "33389023590", sdf.parse("25-07-1990"), "M");
		PessoaJuridica empresa1 = new PessoaJuridica("lanchonete pao com ovo", "98765432000800", sdf.parse("15-08-2010"));
		PessoaFisicaRepository pfr = new PessoaFisicaRepository();
		PessoaJuridicaRepository pjr = new PessoaJuridicaRepository();
		ContaFisicaRepository cfr = new ContaFisicaRepository();
		ContaFisica conta1 = new ContaFisica("123-4", "5010-1", TipoConta.FISICA, titular1);
		ContaJuridicaRepository cjr = new ContaJuridicaRepository();
		ContaJuridica conta2 = new ContaJuridica("123-4", "10005-0", TipoConta.JURIDICA, empresa1);
		

		
		/* INSERIR PESSOA FISICA E JURIDICA
		 */
//		System.out.println(pfr.inserirPessoaFisica(titular1));
//		
//		System.out.println(pjr.inserirPessoaJuridica(empresa1));
		
		
		/* LISTAR PESSOAS FISICAS E JURIDICAS  
		 */
		
//		ArrayList<PessoaFisica> listaResult = pfr.listarPessoaFisica();
//		for (PessoaFisica p : listaResult) {
//			System.out.println(p);
//		}

//		ArrayList<PessoaJuridica> listaResult = pjr.listarPessoaJuridica();
//		for (PessoaJuridica p : listaResult) {
//			System.out.println(p);
//		}
		
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
//		int id = input.nextInt();
//		System.out.println(pjr.excluirPessoaJuridica(id));

		
		/* INSERIR CONTA FISICA E JURIDICA
		 */
//		System.out.println(cfr.inserirContaFisica(conta1));
//		System.out.println(cjr.inserirContaJuridica(conta2));
		
		
		/* LISTAR CONTAS FISICAS E JURIDICAS
		 */
//		ArrayList<ContaFisica> lista1 = cfr.listarContasFisicas();
//		ArrayList<ContaJuridica> lista2 = cjr.listarContasJuridicas();
//		ArrayList<Conta> listaGeral = new ArrayList<>();
//		copyList(lista1, listaGeral);
//		copyList(lista2, listaGeral);
//		printList(listaGeral);
		
		/* CONSULTAR PESSOAS FISICAS E JURIDICAS POR ID
		 */
//		System.out.println(cfr.consultarContaFisica(13));
//		System.out.println(cjr.consultarContaJuridica(7));
//		
		
//		ALTERAR CONTA FISICA E JURIDICA
		
//		System.out.println(cjr.alterarContaJuridica(empresa1, 7));
		
		/* EXCLUIR CONTA FISICA
		 */
//		System.out.println(cfr.excluirContaFisica(2));
//		System.out.println(cjr.excluirContaJuridica(5));

		
	}
	
	public static void copyList(ArrayList<? extends Conta> listaOrigem, ArrayList<? super Conta> listaDestino) {
		for (Conta c : listaOrigem) {
			listaDestino.add(c);
		}
	}
	
	public static void printList(ArrayList<?> list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

}
