package com.entra21.cashsolidario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.entra21.cashsolidario.entity.Banco;
import com.entra21.cashsolidario.entity.Endereco;

@Service
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Autowired
	public default boolean enderecoExcluiCliente(Long id) {
		boolean excluiu = false;

		// Conectar no banco
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM ENDERECO " + " WHERE FK_IDCLIENTE = ? ";
		// Obter o preparedStatement
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			// Executar
			stmt.setLong(1, id);
			int registrosExcluidos = stmt.executeUpdate();
			excluiu = (registrosExcluidos > 0);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir cliente.\nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return excluiu;
	}

	@Autowired
	public default boolean enderecoExcluiEntidade(Long id) {boolean excluiu = false;

	// Conectar no banco
	Connection conexao = Banco.getConnection();
	String sql = " DELETE FROM ENDERECO " + " WHERE FK_IDENTIDADE = ? ";
	// Obter o preparedStatement
	PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
	try {
		// Executar
		stmt.setLong(1, id);
		int registrosExcluidos = stmt.executeUpdate();
		excluiu = (registrosExcluidos > 0);
	} catch (SQLException e) {
		System.out.println("Erro ao excluir entidade.\nCausa: " + e.getMessage());
	} finally {
		Banco.closePreparedStatement(stmt);
		Banco.closeConnection(conexao);
	}

	return excluiu;}

}
