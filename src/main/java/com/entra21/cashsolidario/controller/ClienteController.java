package com.entra21.cashsolidario.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
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

import com.entra21.cashsolidario.entity.Cliente;
import com.entra21.cashsolidario.entity.Endereco;
import com.entra21.cashsolidario.facemodels.ClienteEntidadeEndereco;
import com.entra21.cashsolidario.repository.ClienteRepository;
import com.entra21.cashsolidario.repository.EnderecoRepository;

@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteEntidadeEndereco clienteEndereco;
	
	
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
	public ResponseEntity<?> salvar(@RequestBody ClienteEntidadeEndereco c) {
		System.out.println(c);
		Cliente novoCliente = new Cliente();
		novoCliente.setId(c.getId());
		novoCliente.setNome(c.getNome());
		novoCliente.setCpf(c.getCpf());
		Cliente clienteGravado = clienteRepository.saveAndFlush(novoCliente);
		Endereco novoEndereco = new Endereco();
		novoEndereco.setFk_idCliente(clienteGravado.getId());
		novoEndereco.setLogradouro(c.getLogradouro());
		novoEndereco.setNumero(c.getNumero());
		novoEndereco.setComplemento(c.getComplemento());
		novoEndereco.setBairro(c.getBairro());
		novoEndereco.setCep(c.getCep());
		novoEndereco.setCidade(c.getCidade());
		novoEndereco.setUf(c.getUf());
		novoEndereco.setId(c.getEndId());
		
		enderecoRepository.saveAndFlush(novoEndereco);
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

	@GetMapping(value = "clienteid/{id}")
	@ResponseBody
	public ResponseEntity<?> ClienteID(@PathVariable("id") Long id) {
		
		Cliente c = clienteRepository.findById(id).get();
		Endereco ec = new Endereco() ;
		ec = enderecoRepository.procuraEnderecoCliente(id);
		ClienteEntidadeEndereco clienteCompleto = new ClienteEntidadeEndereco();
		clienteCompleto.setNome(c.getNome());
		clienteCompleto.setCpf(c.getCpf());
		clienteCompleto.setLogradouro(ec.getLogradouro());
		clienteCompleto.setNumero(ec.getNumero());
		clienteCompleto.setComplemento(ec.getComplemento());
		clienteCompleto.setBairro(ec.getBairro());
		clienteCompleto.setCep(ec.getCep());
		clienteCompleto.setCidade(ec.getCidade());
		clienteCompleto.setUf(ec.getUf());
		clienteCompleto.setFk_idCliente(ec.getFk_idCliente());
		clienteCompleto.setId(c.getId());
		clienteCompleto.setEndId(ec.getId());
		return new ResponseEntity<ClienteEntidadeEndereco>(clienteCompleto, HttpStatus.OK);
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
	
}





