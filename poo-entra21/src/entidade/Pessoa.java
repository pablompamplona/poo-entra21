package entidade;

public class Pessoa {
	
	private String nome;
	private String dataNascimento;
	private String cpf;
	private char sexo;
	
	//Construtores
	public Pessoa(String nomeDaPessoa, String cpf) {
		this.nome = nomeDaPessoa;
		this.cpf = cpf;
	}
	
	//Metodos
	public int calcularIdade(int anoAtual) {
		int idade = 0;
		//Assumir dd/MM/yyyy
		String anoNascimento = this.dataNascimento.substring(6);
		idade = anoAtual - Integer.valueOf(anoNascimento);
		
		return idade;
	}
	
	//getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	

}
