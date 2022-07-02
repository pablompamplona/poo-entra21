package principal;

import entidade.ContaLista1;

public class PrincipalLista1 {

	public static void main(String[] args) {
		
		ContaLista1 conta1 = new ContaLista1("123-7", "12345-6", 300.0);
		
		System.out.println("Agencia: " + conta1.getNumeroAgencia() + " Conta: " + conta1.getNumeroConta());
		System.out.println("");
		
		System.out.println("Saldo Atual: R$" + conta1.getSaldo());
		System.out.println("Valor Sacado: R$" + conta1.sacarValor(250.0));
		System.out.println("Saldo Atualizado: R$" + conta1.getSaldo());
		System.out.println("");
		System.out.println("Valor Sacado: R$" + conta1.sacarValor(300.0));
		System.out.println("Saldo Atualizado: R$" + conta1.getSaldo());
		System.out.println("");
		System.out.println("Valor Depositado: R$ " + conta1.depositarValor(200.0));
		System.out.println("Saldo Atualizado: R$ " + conta1.getSaldo());
		System.out.println("");
		System.out.println("Rendimento Recebido: R$ " + conta1.efetuarRendimento(0.5));
		System.out.println("Saldo Atualizado: R$ " + conta1.getSaldo());
		System.out.println("");
		System.out.println("Rendimento Recebido: R$ " + conta1.efetuarRendimento(0.8));
		System.out.println("Saldo Atualizado: R$ " + conta1.getSaldo());
		
	}

}
