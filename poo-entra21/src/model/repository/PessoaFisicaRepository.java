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
	public Pessoa inserirPessoaFisica(PessoaFisica novaPessoaFisica) {
		Connection conm = Banco.getConnection();
		String query = "INSERT INTO pessoas_fisicas (nome, cpf, data_nascto, sexo, adimplente) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
		
		
		try {
			stmt.setString(1, novaPessoaFisica.getNome());
			stmt.setString(2, novaPessoaFisica.getCpf());
			stmt.setDate(3, new Date(novaPessoaFisica.getDataNascimento().getTime()));
			stmt.setString(4, novaPessoaFisica.getSexo());
			stmt.setBoolean(5, true);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro de insercao no Banco: " + e.getMessage());
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
			resultado = stmt.executeQuery("select * from pessoas_fisicas;");
			while (resultado.next()) {
				PessoaFisica pf = new PessoaFisica();
				pf.setNome(resultado.getString(2));
				pf.setCpf(resultado.getString(3));
				pf.setDataNascimento(resultado.getDate(4));
				pf.setSexo(resultado.getString(5));
				pf.setAdimplente(resultado.getBoolean(6));
				listaResult.add(pf);
			}
		}	
		 catch (SQLException e) {
			System.out.println("Erro de Consulta no BD: " + e.getCause());
		}
		return (listaResult);
	}
	
	public PessoaFisica consultarPessoaFisica (int id) {
		Connection conm = Banco.getConnection();
		String query = "select * from pessoas_fisicas where id_pf = " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
		ResultSet resultado;
		PessoaFisica pf = new PessoaFisica();
		try {
			resultado = stmt.executeQuery(query);
			pf.setNome(resultado.getString(2));
			pf.setCpf(resultado.getString(3));
			pf.setDataNascimento(resultado.getDate(4));
			pf.setSexo(resultado.getString(5));
			pf.setAdimplente(resultado.getBoolean(6));
		}
		catch (SQLException e) {
			System.out.println("Erro de Consulta no BD: " + e.getCause());
		}
		return pf;
	}
	
	//update
	public Pessoa alterarPessoaFisica (int id) {
		
		return null;
	}
	
	//delete
	public boolean excluirPessoaFisica (int id) {
		
		return false;
	}
}
