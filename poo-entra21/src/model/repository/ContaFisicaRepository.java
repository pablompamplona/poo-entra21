package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.util.ArrayList;

import model.Banco;
import model.entidade.Conta;
import model.entidade.ContaFisica;
import model.entidade.enums.TipoConta;

public class ContaFisicaRepository {
	
	//create
	//TODO recuperar id_conta_pf
	public ContaFisica inserirContaFisica(ContaFisica novaContaFisica) {
		Connection conm = Banco.getConnection();
		String query = "INSERT INTO contas_pf (agencia,numero_conta,tipo_conta,id_pf) VALUES (?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conm,query);
		ResultSet resultado = null;
		
		try {
			conm.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, novaContaFisica.getNumeroAgencia());
			stmt.setString(2, novaContaFisica.getNumeroConta());
			stmt.setString(3, novaContaFisica.getTipo().toString());
			stmt.setInt(4, novaContaFisica.getTitular().getIdPf());
			stmt.executeUpdate();
			resultado = stmt.getGeneratedKeys();
			if (resultado.next()) {
				novaContaFisica.setIdContaFisica(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro de insercao no Banco: " + e.getMessage());
		}
		return novaContaFisica;
	}
	
	//retrieve
	public ArrayList<ContaFisica> listarContasFisicas() {
		ArrayList<ContaFisica> listaResult = new ArrayList<>();
		Connection conm = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conm, "select * from contas_pf;");
		ResultSet resultado;
		
		try {
			resultado = stmt.executeQuery();
			while(resultado.next()) {
				ContaFisica conta = new ContaFisica();
				conta.setIdContaFisica(resultado.getInt(1));
				conta.setNumeroAgencia(resultado.getString(2));
				conta.setNumeroConta(resultado.getString(3));
				conta.setTipo(TipoConta.valueOf(resultado.getString(4).toUpperCase()));
				conta.setIdTitular(resultado.getInt(5));
				listaResult.add(conta);
			}
		} catch (SQLException e) {
			System.out.println("Erro de Consulta no BD: " + e.getMessage());
		}
		return (listaResult);
	}
	
	public ContaFisica consultarContaFisica(int id) {
		Connection conm = Banco.getConnection();
		String query = "select * from contas_pf where id_pf = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
		ResultSet resultado = null;
		ContaFisica conta = new ContaFisica();
		try {
			stmt.setInt(1, id);
			resultado = stmt.executeQuery();
			if (resultado != null && resultado.next()) {
				conta.setIdContaFisica(resultado.getInt(1));
				conta.setNumeroAgencia(resultado.getString(2));
				conta.setNumeroConta(resultado.getString(3));
				conta.setTipo(TipoConta.valueOf(resultado.getString(4).toUpperCase()));
				conta.setIdTitular(resultado.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println("Erro de Consulta no BD: " + e.getMessage());
		}
		
		return conta;
	}
	
	//update
	// TODO verificar quais campos alterar >> titular?
	public Conta alterarContaFisica(int id) {
		
		return null;
	}
	
	//delete
	public boolean excluirContaFisica(int id) {
		Connection conm = Banco.getConnection();
		String query = "DELETE FROM contas_pf WHERE id_contas_pf = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
		
		try {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro de Exclusao no BD: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	
	}

}
