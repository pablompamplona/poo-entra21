package entidade;

import java.util.ArrayList;

public class PessoaJuridicaLista1 extends PessoaLista1 {
	
	private String cnpj;
	private String dataAbertura;
	private ArrayList<ContaLista1> contasPj = new ArrayList();
	
	
	public PessoaJuridicaLista1() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	public PessoaJuridicaLista1(String nome, boolean adimplente, String cnpj, String dataAbertura) {
		super(nome, adimplente);
		this.cnpj = cnpj;
		this.dataAbertura = dataAbertura;
	}

	public boolean verificarAdimplencia() {
		double saldoGeral = 0;
		for (int i = 0; i < contasPj.size(); i++) {
			saldoGeral += contasPj.get(i).getSaldo();
			}
		if (saldoGeral < (-1000.0)) {
			super.setAdimplente(false);	
			return super.isAdimplente();
		}
		super.setAdimplente(true);
		return super.isAdimplente();
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	
	

}
