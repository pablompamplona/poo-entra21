package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Banco;
import model.entidade.Conta;
import model.entidade.ContaFisica;
import model.entidade.ContaJuridica;
import model.entidade.enums.TipoConta;

public class ContaJuridicaRepository {
	
	//create
	//TODO recuperar id_conta_pj
	public ContaJuridica inserirContaJuridica(ContaJuridica novaContaJuridica) {
		Connection conm = Banco.getConnection();
		String query = "INSERT INTO contas_pj (agencia,numero_conta,tipo_conta,id_pj) VALUES (?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conm, query);
		ResultSet resultado = null;
		
		try {
			conm.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, novaContaJuridica.getNumeroAgencia());
			stmt.setString(2, novaContaJuridica.getNumeroConta());
			stmt.setString(3, novaContaJuridica.getTipo().toString());
			stmt.setInt(4, novaContaJuridica.getTitular().getIdPj());
			stmt.executeUpdate();
			resultado = stmt.getGeneratedKeys();
			if(resultado.next()) {
				novaContaJuridica.setIdContaJuridica(resultado.getInt(1));
			}
		} 
		catch (SQLException e) {
			System.out.println("Erro de insercao no Banco: " + e.getMessage());
		}
		finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conm);
		}
		return novaContaJuridica;
	}
	
	//retrieve
	public ArrayList<ContaJuridica> listarContasJuridicas() {
		ArrayList<ContaJuridica> listaResult = new ArrayList<>();
		Connection conm = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conm, "select * from contas_pj;");
		ResultSet resultado;
		
		try {
			resultado = stmt.executeQuery();
			while (resultado != null && resultado.next()) {
				ContaJuridica conta = new ContaJuridica();
				conta.setIdContaJuridica(resultado.getInt(1));
				conta.setNumeroAgencia(resultado.getString(2));
				conta.setNumeroConta(resultado.getString(3));
				conta.setTipo(TipoConta.valueOf(resultado.getString(4).toUpperCase()));
				conta.setIdTitular(resultado.getInt(5));
				listaResult.add(conta);
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
	
	public ContaJuridica consultarContaJuridica(int id) {
		Connection conm = Banco.getConnection();
		String query = "select * from contas_pj where id_contas_pj = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
		ResultSet resultado = null;
		ContaJuridica conta = new ContaJuridica();
		
		try {
			stmt.setInt(1, id);
			resultado = stmt.executeQuery();
			if (resultado.next()) {
				conta.setIdContaJuridica(resultado.getInt(1));
				conta.setNumeroAgencia(resultado.getString(2));
				conta.setNumeroConta(resultado.getString(3));
				conta.setTipo(TipoConta.valueOf(resultado.getString(4).toUpperCase()));
				conta.setIdTitular(resultado.getInt(5));
			}
		} 
		catch (SQLException e) {
			System.out.println("Erro de Consulta no BD: " + e.getMessage());
		}
		finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conm);
		}
		return conta;
	}
	
	//update
	// TODO verificar quais campos alterar >> titular?
	public ContaJuridica alterarContaJuridica(int id) {
		
		return null;
	}
	
	//delete
	public boolean excluirContaJuridica(int id) {
		boolean excluiu = false;
		Connection conm = Banco.getConnection();
		String query = "DELETE FROM contas_pj WHERE id_contas_pj = ?";
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
