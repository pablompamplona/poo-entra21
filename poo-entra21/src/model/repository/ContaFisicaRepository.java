package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;

import model.Banco;
import model.entidade.Conta;
import model.entidade.ContaFisica;
import model.entidade.enums.TipoConta;

public class ContaFisicaRepository {
	
	//create
	public ContaFisica inserirContaFisica(ContaFisica novaContaFisica) {
		Connection conm = Banco.getConnection();
		String query = "INSERT INTO contas_pf (agencia,numero_conta,tipo_conta,id_pf) VALUES (?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conm, query);
		
		try {
			stmt.setString(1, novaContaFisica.getNumeroAgencia());
			stmt.setString(2, novaContaFisica.getNumeroConta());
			stmt.setString(3, novaContaFisica.getTipo().name());
			stmt.setInt(4, novaContaFisica.getTitular().getIdPf());
			stmt.executeUpdate();
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
//				conta.setTipo(resultado.getString(4));
				conta.setIdTitular(resultado.getInt(5));
				listaResult.add(conta);
			}
		} catch (SQLException e) {
			System.out.println("Erro de Consulta no BD: " + e.getMessage());
		}
		return (listaResult);
	}
	
	//update
	public Conta alterarContaFisica(int id) {
		
		return null;
	}
	
	//delete
	public boolean excluirContaFisica(int id) {
		
		return false;
	}

}
