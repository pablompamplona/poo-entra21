package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			PreparedStatement stmt = Banco.getPreparedStatementWithPk(conm, query);
			ResultSet resultado = null;
			
			try {
				conm.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, novaPessoaJuridica.getNome());
				stmt.setString(2, novaPessoaJuridica.getCnpj());
				stmt.setDate(3, new Date(novaPessoaJuridica.getDataAbertura().getTime()));
				stmt.setBoolean(4, true);
				stmt.executeUpdate();
				resultado = stmt.getGeneratedKeys();
				if (resultado.next()) {
					novaPessoaJuridica.setIdPj(resultado.getInt(1));
				}
			} catch (SQLException e) {
				System.out.println("Erro de insercao no Banco: " + e.getMessage());
			}
			finally {
				Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conm);
			}
			return novaPessoaJuridica;
		}
		
		//retrieve
		public ArrayList<PessoaJuridica> listarPessoasJuridicas() {
			ArrayList<PessoaJuridica> listaResult = new ArrayList();
			Connection conm = Banco.getConnection();
			PreparedStatement stmt = Banco.getPreparedStatement(conm, "SELECT * FROM pessoas_juridicas;");
			ResultSet resultado;
			
			try {
				resultado = stmt.executeQuery();
				while (resultado.next()) {
					PessoaJuridica pj = new PessoaJuridica();
					pj.setIdPj(resultado.getInt("id_pj"));
					pj.setNome(resultado.getString("nome"));
					pj.setCnpj(resultado.getString("cnpj"));
					pj.setDataAbertura(resultado.getDate("data_abertura"));
					pj.setAdimplente(resultado.getBoolean("adimplente"));
					listaResult.add(pj);
				}
			} 
			catch (SQLException e) {
				System.out.println("Erro de Consulta no BD: " + e.getMessage());
			}
			finally {
				Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conm);
			}
			
			return (listaResult);
		}
		
		public PessoaJuridica consultarPessoaJuridica (int id) {
			Connection conm = Banco.getConnection();
			String query = "SELECT * FROM pessoas_juridicas where id_pj = ?";
			PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
			ResultSet resultado = null;
			PessoaJuridica pj = new PessoaJuridica();
			
			try {
				stmt.setInt(1, id);
				resultado = stmt.executeQuery();
				while (resultado != null && resultado.next()) {
					pj.setIdPj(resultado.getInt("id_pj"));
					pj.setNome(resultado.getString("nome"));
					pj.setCnpj(resultado.getString("cnpj"));
					pj.setDataAbertura(resultado.getDate("data_abertura"));
					pj.setAdimplente(resultado.getBoolean("adimplente"));
				}
			} 
			catch (SQLException e) {
				System.out.println("Erro de Consulta no BD: " + e.getMessage());
			}
			finally {
				Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conm);
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
			} 
			catch (SQLException e) {
				System.out.println("Erro de insercao no Banco: " + e.getMessage());
			}
			finally {
				Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conm);
			}
			return novaPessoaJuridica;
		}
		
		//delete
		public boolean excluirPessoaJuridica (int id) {
			boolean excluiu = false;
			Connection conm = Banco.getConnection();
			String query = "DELETE FROM pessoas_juridicas WHERE id_pj = ?";
			PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
			
			try {
				stmt.setInt(1, id);
				int registrosExcluidos = stmt.executeUpdate();
				excluiu = (registrosExcluidos > 0);
				return excluiu;
			} 
			catch (SQLException e) {
				System.out.println("Erro de Exclusao no BD: " + e.getMessage());
				return false;
			}
			finally {
				Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conm);
			}
			
		}

}
