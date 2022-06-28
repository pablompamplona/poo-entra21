package entidade;

public class Vacina {
	
	//Atributos
	private String paisOrigem;
	private int estagioPesquisa;
	//TODO trocar para tipo data
	private String dtInicioPesquisa;
	private String pesquisadorResponsavel;
	
	//Metodos
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public int getEstagioPesquisa() {
		return estagioPesquisa;
	}
	public void setEstagioPesquisa(int estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}
	public String getDtInicioPesquisa() {
		return dtInicioPesquisa;
	}
	public void setDtInicioPesquisa(String dtInicioPesquisa) {
		this.dtInicioPesquisa = dtInicioPesquisa;
	}
	public String getPesquisadorResponsavel() {
		return pesquisadorResponsavel;
	}
	public void setPesquisadorResponsavel(String pesquisadorResponsavel) {
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}
	
	

}
