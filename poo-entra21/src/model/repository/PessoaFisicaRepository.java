package model.repository;

import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Banco;
import model.entidade.Pessoa;
import model.entidade.PessoaFisica;

public class PessoaFisicaRepository {
	
	//create
	//TODO recuperar id_pf
	public PessoaFisica inserirPessoaFisica(PessoaFisica novaPessoaFisica) {
		Connection conm = Banco.getConnection();
		String query = "INSERT INTO pessoas_fisicas (nome, cpf, data_nascto, sexo, adimplente) VALUES (?, ? , ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conm, query);
		ResultSet resultado = null;
		
		try {
			conm.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, novaPessoaFisica.getNome());
			stmt.setString(2, novaPessoaFisica.getCpf());
			stmt.setDate(3, new Date(novaPessoaFisica.getDataNascimento().getTime()));
			stmt.setString(4, novaPessoaFisica.getSexo());
			stmt.setBoolean(5, true);
			stmt.executeUpdate();
			resultado = stmt.getGeneratedKeys();
			if(resultado.next()) {
				novaPessoaFisica.setIdPf(resultado.getInt(1));
			}
		} 
		catch (SQLException e) {
			System.out.println("Erro de insercao no Banco: " + e.getMessage());
		}
		finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conm);
		}
		return novaPessoaFisica;
	}
	
	//retrieve
	public ArrayList<PessoaFisica> listarPessoaFisica() {
		ArrayList<PessoaFisica> listaResult = new ArrayList();
		Connection conm = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conm, "select * from pessoas_fisicas;");
		ResultSet resultado;
		try {
			resultado = stmt.executeQuery();
			while (resultado.next()) {
				PessoaFisica pf = new PessoaFisica();
				pf.setIdPf(resultado.getInt("id_pf"));
				pf.setNome(resultado.getString("nome"));
				pf.setCpf(resultado.getString("cpf"));
				pf.setDataNascimento(resultado.getDate("data_nascto"));
				pf.setSexo(resultado.getString("sexo"));
				pf.setAdimplente(resultado.getBoolean("adimplente"));
				listaResult.add(pf);
			}
		}	
		catch (SQLException e) {
			System.out.println("Erro de Consulta no BD: " + e.getCause());
		}
		finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conm);
		}
		return (listaResult);
	}
	
	public PessoaFisica consultarPessoaFisica (int id) {
		Connection conm = Banco.getConnection();
		String query = "select * from pessoas_fisicas where id_pf = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
		ResultSet resultado = null;
		PessoaFisica pf = new PessoaFisica();
		try {
			stmt.setInt(1, id);
			resultado = stmt.executeQuery();
			if (resultado != null && resultado.next()) {
				pf.setIdPf(resultado.getInt("id_pf"));
				pf.setNome(resultado.getString("nome"));
				pf.setCpf(resultado.getString("cpf"));
				pf.setDataNascimento(resultado.getDate("data_nascto"));
				pf.setSexo(resultado.getString("sexo"));
				pf.setAdimplente(resultado.getBoolean("adimplente"));
			}	
		}
		catch (SQLException e) {
			System.out.println("Erro de Consulta no BD: " + e.getMessage());
		}
		finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conm);
		}
		return pf;
	}
	
	//update
	public Pessoa alterarPessoaFisica (PessoaFisica novaPessoaFisica, int id) {
		Connection conm = Banco.getConnection();
		String query = "UPDATE pessoas_fisicas SET nome = ?,cpf = ?,data_nascto = ?,sexo = ? WHERE id_pf = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
		
		try {
			stmt.setString(1, novaPessoaFisica.getNome());
			stmt.setString(2, novaPessoaFisica.getCpf());
			stmt.setDate(3, new Date(novaPessoaFisica.getDataNascimento().getTime()));
			stmt.setString(4, novaPessoaFisica.getSexo());
			stmt.setInt(5, id);
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println("Erro de insercao no Banco: " + e.getMessage());
		}
		finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conm);
		}
		
		return novaPessoaFisica;
	}
	
	//delete
	//TODO verificar se cliente é titular de conta
	public boolean excluirPessoaFisica (int id) {
		boolean excluiu = false;
		Connection conm = Banco.getConnection();
		String query = "DELETE FROM pessoas_fisicas WHERE id_pf = ?";
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
