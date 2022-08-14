package model.entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PessoaJuridica extends Pessoa {
	
	private int idPj;
	private String cnpj;
	private Date dataAbertura;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public PessoaJuridica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaJuridica(String nome, String cnpj, Date dataAbertura) {
		super(nome);
		this.cnpj = cnpj;
		this.dataAbertura = dataAbertura;
		
	}

	public boolean verificarAdimplencia() {
		double saldoGeral = 0;
		for (int i = 0; i < super.getContas().size(); i++) {
			saldoGeral += super.getContas().get(i).getSaldo();
			}
		if (saldoGeral < (-1000.0)) {
			super.setAdimplente(false);	
			return super.isAdimplente();
		}
		super.setAdimplente(true);
		return super.isAdimplente();
	}
	
	
	public int getIdPj() {
		return idPj;
	}
	public void setIdPj(int idPj) {
		this.idPj = idPj;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	@Override
	public String toString() {
		return "ID: " + idPj + "\n" +
				"Nome: " + getNome() + "\n" +
				"CNPJ: " + cnpj + "\n" +
				"Data de Abertura: " + sdf.format(dataAbertura);
	}
	

}
