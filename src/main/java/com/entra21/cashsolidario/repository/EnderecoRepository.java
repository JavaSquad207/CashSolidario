package com.entra21.cashsolidario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public default Endereco procuraEnderecoCliente(Long id) {
		Endereco enderecoBuscado = new Endereco();
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM ENDERECO WHERE FK_IDCLIENTE = ? ";
		// Obter o preparedStatement
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			stmt.setLong(1, id);
			ResultSet rst = stmt.executeQuery();
			if (rst.next()) {
				enderecoBuscado.setId(rst.getLong("id"));
				enderecoBuscado.setLogradouro(rst.getString("logradouro"));
				enderecoBuscado.setNumero(rst.getInt("numero"));
				enderecoBuscado.setComplemento(rst.getString("complemento"));
				enderecoBuscado.setBairro(rst.getString("bairro"));
				enderecoBuscado.setCep(rst.getString("cep"));
				enderecoBuscado.setCidade(rst.getString("cidade"));
				enderecoBuscado.setUf(rst.getString("uf"));
				enderecoBuscado.setFk_idCliente(rst.getLong("fk_idCliente"));
			}

		} catch (SQLException e) {
			System.out.println("Erro " + e);
		}
		return enderecoBuscado;
	}
	
	@Autowired
	public default Endereco procuraEnderecoEntidade(Long id) {
		Endereco enderecoBuscado = new Endereco();
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM ENDERECO WHERE FK_IDENTIDADE = ? ";
		// Obter o preparedStatement
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			stmt.setLong(1, id);
			ResultSet rst = stmt.executeQuery();
			if (rst.next()) {
				enderecoBuscado.setId(rst.getLong("id"));
				enderecoBuscado.setLogradouro(rst.getString("logradouro"));
				enderecoBuscado.setNumero(rst.getInt("numero"));
				enderecoBuscado.setComplemento(rst.getString("complemento"));
				enderecoBuscado.setBairro(rst.getString("bairro"));
				enderecoBuscado.setCep(rst.getString("cep"));
				enderecoBuscado.setCidade(rst.getString("cidade"));
				enderecoBuscado.setUf(rst.getString("uf"));
				enderecoBuscado.setFk_idEntidade(rst.getLong("fk_idEntidade"));
			}

		} catch (SQLException e) {
			System.out.println("Erro " + e);
		}
		return enderecoBuscado;
	}

	@Autowired
	public default boolean enderecoExcluiCliente(Long id) {
		boolean excluiu = false;

		// Conectar no banco
		Connection conexao = Banco.getConnection();
		String contasql = "select count(*) FROM ENDERECO WHERE FK_IDCLIENTE = ? ";
		String sql = " DELETE FROM ENDERECO  WHERE FK_IDCLIENTE = ? ";
		String sqlDeletaCliente = " DELETE FROM CLIENTE WHERE ID = ?";
		// Obter o preparedStatement
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		PreparedStatement contastmt = Banco.getPreparedStatement(conexao, contasql);
		PreparedStatement stmtDeletaCliente = Banco.getPreparedStatement(conexao, sqlDeletaCliente);

		try {
			System.out.println("REGISTRO ID " + id);

			contastmt.setLong(1, id);

			ResultSet rst = contastmt.executeQuery();
			rst.next();
			int registrocontado = rst.getInt(1);
			System.out.println("REGISTROS CONTADOS " + registrocontado);

			if (registrocontado > 1) {
				Banco.closePreparedStatement(contastmt);
				Banco.closePreparedStatement(stmt);
				Banco.closePreparedStatement(stmtDeletaCliente);
				Banco.closeConnection(conexao);
				rst.close();
				return false;
			} else {
				stmtDeletaCliente.setLong(1, id);
				stmtDeletaCliente.executeUpdate();
				Banco.closePreparedStatement(stmtDeletaCliente);
				rst.close();

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

			}
		} catch (Exception e) {

		}

		return excluiu;
	}

	@Autowired
	public default boolean enderecoExcluiEntidade(Long id) {
		boolean excluiu = false;

		// Conectar no banco
		Connection conexao = Banco.getConnection();
		String contasql = "select count(*) FROM ENDERECO WHERE FK_IDENTIDADE = ? ";
		String sql = " DELETE FROM ENDERECO  WHERE FK_IDENTIDADE = ? ";
		String sqlDeletaEntidade = " DELETE FROM ENTIDADE WHERE ID = ?";
		// Obter o preparedStatement
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		PreparedStatement contastmt = Banco.getPreparedStatement(conexao, contasql);
		PreparedStatement stmtDeletaEntidade = Banco.getPreparedStatement(conexao, sqlDeletaEntidade);

		try {
			System.out.println("REGISTRO ID " + id);

			contastmt.setLong(1, id);

			ResultSet rst = contastmt.executeQuery();
			rst.next();
			int registrocontado = rst.getInt(1);
			System.out.println("REGISTROS CONTADOS " + registrocontado);

			if (registrocontado > 1) {
				Banco.closePreparedStatement(contastmt);
				Banco.closePreparedStatement(stmt);
				Banco.closePreparedStatement(stmtDeletaEntidade);
				Banco.closeConnection(conexao);
				rst.close();
				return false;
			} else {
				stmtDeletaEntidade.setLong(1, id);
				stmtDeletaEntidade.executeUpdate();
				Banco.closePreparedStatement(stmtDeletaEntidade);
				rst.close();

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

			}
		} catch (Exception e) {

		}

		return excluiu;
	}

}
