package com.entra21.cashsolidario.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.cashsolidario.entity.Banco;
import com.entra21.cashsolidario.entity.Cliente;
import com.entra21.cashsolidario.entity.Endereco;
import com.entra21.cashsolidario.facemodels.ClienteEndereco;
import com.entra21.cashsolidario.repository.ClienteRepository;
import com.entra21.cashsolidario.repository.EnderecoRepository;

@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteEndereco clienteEndereco;
	
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping(value = "salvarId")
	@ResponseBody
	public ResponseEntity<Cliente> salvarId(@RequestBody Cliente c) {
		Cliente cliente = clienteRepository.save(c);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}

	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<?> salvar(@RequestBody ClienteEndereco c) {
		Cliente novoCliente = new Cliente();
		novoCliente.setNome(c.getNome());
		novoCliente.setCpf(c.getCpf());
		Cliente clienteGravado = clienteRepository.save(novoCliente);
		Endereco novoEndereco = new Endereco();
		novoEndereco.setFk_idCliente(clienteGravado.getId());
		novoEndereco.setLogradouro(c.getLogradouro());
		novoEndereco.setNumero(c.getNumero());
		novoEndereco.setComplemento(c.getComplemento());
		novoEndereco.setBairro(c.getBairro());
		novoEndereco.setCep(c.getCep());
		novoEndereco.setCidade(c.getCidade());
		novoEndereco.setUf(c.getUf());
		enderecoRepository.save(novoEndereco);
		return new ResponseEntity<Cliente>(clienteGravado, HttpStatus.CREATED);
	}

	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Cliente>> listaCliente() {
		List<Cliente> cliente = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
	}

	
	
	@GetMapping(value = "delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Cliente id) {
		clienteRepository.delete(id);
		enderecoRepository.enderecoExcluiCliente(id.getId());
		
		return new ResponseEntity<String>("Cliente Excluído com Sucesso", HttpStatus.OK);

	}

	@GetMapping(value = "clienteid")
	@ResponseBody
	public ResponseEntity<Cliente> ClienteID(@PathVariable("id") Long id) {
		Cliente c = clienteRepository.findById(id).get();
		return new ResponseEntity<Cliente>(c, HttpStatus.OK);
	}

	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente c) {
		Cliente cliente = clienteRepository.saveAndFlush(c);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@GetMapping(value = "atualizarGen")
	@ResponseBody
	public ResponseEntity<?> atualizarGen(@RequestBody Cliente c) {
		if (c.getId() == null) {
			return new ResponseEntity<String>("Registro Inválido", HttpStatus.OK);
		}
		Cliente cliente = clienteRepository.saveAndFlush(c);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	@PostMapping(value = "salvar001")
	@ResponseBody
	public ResponseEntity<?> salvar001(@RequestBody Cliente c) {
		Cliente cliente = clienteRepository.save(c);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	
	public boolean enderecoExcluiCliente(Long id) {
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
			System.out.println("Erro ao excluir clente.\nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return excluiu;
	}

	
	
	
	
}





