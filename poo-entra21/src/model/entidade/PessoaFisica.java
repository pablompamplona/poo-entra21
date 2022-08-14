package model.entidade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PessoaFisica extends Pessoa {
	
	private int idPf;
	private String cpf;
	private Date dataNascimento;
	private String sexo;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
			
	//Construtores
	public PessoaFisica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PessoaFisica(String nome, String cpf, Date dataNascimento, String sexo) throws ParseException {
		super(nome);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	public boolean verificarAdimplencia() {
		double saldoGeral = 0;
		for (int i = 0; i < super.getContas().size(); i++) {
			saldoGeral += super.getContas().get(i).getSaldo();
		}
		if (saldoGeral < (-500.0)) {
			super.setAdimplente(false);	
		}else {
			super.setAdimplente(true);
		}
		return super.isAdimplente();
	}

	public int calcularIdade(PessoaFisica pessoa) {
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(pessoa.getDataNascimento());
		Calendar hoje = Calendar.getInstance();
		int idade = dataNascimento.get(Calendar.YEAR) - hoje.get(Calendar.YEAR);
		return idade;
	}
	
	public int getIdPf() {
		return idPf;
	}

	public void setIdPf(int idPf) {
		this.idPf = idPf;
	}

	//getters and Setters
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
		@Override
		public String toString() {
			return "ID: " + idPf + "\n" +
					"Nome: " + getNome() + "\n" +
					"CPF: " + cpf + "\n" +
					"Data de Nascimento: " + sdf.format(dataNascimento) + "\n" +
					"Sexo: " + sexo;
		}
	
	
	

}
