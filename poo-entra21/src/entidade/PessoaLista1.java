package entidade;

import java.util.ArrayList;

public abstract class PessoaLista1 {
	
	private String nome;
	private boolean adimplente;
	private ArrayList<ContaLista1> contas;
	
	
	public PessoaLista1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaLista1(String nome, boolean adimplente) {
		super();
		this.nome = nome;
		this.adimplente = adimplente;
	}



	public abstract boolean verificarAdimplencia();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAdimplente() {
		return adimplente;
	}

	public void setAdimplente(boolean adimplente) {
		this.adimplente = adimplente;
	}

	public ArrayList<ContaLista1> getContas() {
		return contas;
	}

	public void setContas(ArrayList<ContaLista1> contas) {
		this.contas = contas;
	}
		
	
	
}
