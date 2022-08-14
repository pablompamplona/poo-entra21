package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Banco;
import model.entidade.Pessoa;
import model.entidade.PessoaFisica;
import model.entidade.PessoaJuridica;

public class PessoaJuridicaRepository {
	
	//create
		public PessoaJuridica inserirPessoaJuridica(PessoaJuridica novaPessoaJuridica) {
			Connection conm = Banco.getConnection();
			String query = "INSERT INTO pessoas_juridicas (nome, cnpj, data_abertura, adimplente) VALUES (?,?,?,?)";
			PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
			
			try {
				stmt.setString(1, novaPessoaJuridica.getNome());
				stmt.setString(2, novaPessoaJuridica.getCnpj());
				stmt.setDate(3, new Date(novaPessoaJuridica.getDataAbertura().getTime()));
				stmt.setBoolean(4, true);
				stmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Erro de insercao no Banco: " + e.getMessage());
			}
			return novaPessoaJuridica;
		}
		
		//retrieve
		public ArrayList<PessoaJuridica> listarPessoaJuridica() {
			ArrayList<PessoaJuridica> listaResult = new ArrayList();
			Connection conm = Banco.getConnection();
			PreparedStatement stmt = Banco.getPreparedStatement(conm, "SELECT * FROM pessoas_juridicas;");
			ResultSet resultado;
			
			try {
				resultado = stmt.executeQuery();
				while (resultado.next()) {
					PessoaJuridica pj = new PessoaJuridica();
					pj.setIdPj(resultado.getInt(1));
					pj.setNome(resultado.getString(2));
					pj.setCnpj(resultado.getString(3));
					pj.setDataAbertura(resultado.getDate(4));
					pj.setAdimplente(resultado.getBoolean(5));
					listaResult.add(pj);
				}
			} catch (SQLException e) {
				System.out.println("Erro de Consulta no BD: " + e.getMessage());
			}
			
			return (listaResult);
		}
		
		public Pessoa consultarPessoaJuridica (int id) {
			Connection conm = Banco.getConnection();
			String query = "SELECT * FROM pessoas_juridicas where id_pj = ?";
			PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
			ResultSet resultado = null;
			PessoaJuridica pj = new PessoaJuridica();
			
			try {
				stmt.setInt(1, id);
				resultado = stmt.executeQuery();
				while (resultado != null && resultado.next()) {
					pj.setIdPj(resultado.getInt(1));
					pj.setNome(resultado.getString(2));
					pj.setCnpj(resultado.getString(3));
					pj.setDataAbertura(resultado.getDate(4));
					pj.setAdimplente(resultado.getBoolean(5));
				}
			} catch (SQLException e) {
				System.out.println("Erro de Consulta no BD: " + e.getMessage());
			}
			return pj;
		}
		
		//update
		public PessoaJuridica alterarPessoaJuridica (PessoaJuridica novaPessoaJuridica, int id) {
			Connection conm = Banco.getConnection();
			String query = "UPDATE pessoas_juridicas SET nome = ?, cnpj = ?, data_abertura = ? WHERE id_pj = ?";
			PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
			
			try {
				stmt.setString(1, novaPessoaJuridica.getNome());
				stmt.setString(2, novaPessoaJuridica.getCnpj());
				stmt.setDate(3, new Date(novaPessoaJuridica.getDataAbertura().getTime()));
				stmt.setInt(4, id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Erro de insercao no Banco: " + e.getMessage());
			}
			return novaPessoaJuridica;
		}
		
		//delete
		public boolean excluirPessoaJuridica (int id) {
			Connection conm = Banco.getConnection();
			String query = "DELETE FROM pessoas_juridicas WHERE id_pf = ?";
			PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
			
			try {
				stmt.setInt(1, id);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				System.out.println("Erro de Exclusao no BD: " + e.getMessage());
				return false;
			}
			
		}

}
