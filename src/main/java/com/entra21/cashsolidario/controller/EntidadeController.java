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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.cashsolidario.entity.Banco;
import com.entra21.cashsolidario.entity.Cliente;
import com.entra21.cashsolidario.entity.Endereco;
import com.entra21.cashsolidario.entity.Entidade;
import com.entra21.cashsolidario.facemodels.ClienteEntidadeEndereco;
import com.entra21.cashsolidario.repository.EnderecoRepository;
import com.entra21.cashsolidario.repository.EntidadeRepository;

@RestController
@RequestMapping(value="/entidade")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class EntidadeController {
	
	@Autowired
	private EntidadeRepository entidadeRepository;
	
	@Autowired
	private ClienteEntidadeEndereco clienteEndereco;
	
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@PostMapping(value="salvar")
	@ResponseBody
	public ResponseEntity<Entidade>salvar(@RequestBody ClienteEntidadeEndereco e){
		Entidade novaEntidade = new Entidade();
		novaEntidade.setNome(e.getNome());
		novaEntidade.setCnpj(e.getCnpj());		
		Entidade entidadeGravada = entidadeRepository.save(novaEntidade);
		Endereco novoEndereco = new Endereco();
		novoEndereco.setFk_idEntidade(entidadeGravada.getId());
		novoEndereco.setLogradouro(e.getLogradouro());
		novoEndereco.setNumero(e.getNumero());
		novoEndereco.setComplemento(e.getComplemento());
		novoEndereco.setBairro(e.getBairro());
		novoEndereco.setCep(e.getCep());
		novoEndereco.setCidade(e.getCidade());
		novoEndereco.setUf(e.getUf());
		enderecoRepository.save(novoEndereco);
		return new ResponseEntity<Entidade>(novaEntidade,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Entidade>>listaEntidade(){
		List<Entidade> entidade = entidadeRepository.findAll();
		return new ResponseEntity<List<Entidade>>(entidade, HttpStatus.OK);
	}
	
	@GetMapping(value = "entidadeid001/{id}")
	@ResponseBody
	public ResponseEntity<Entidade> EntidadeID001(@PathVariable("id") Long id) {
		Entidade e = entidadeRepository.findById(id).get();
		return new ResponseEntity<Entidade>(e, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "delete/{id}")
	
	public ResponseEntity<?> delete(@PathVariable("id") Entidade id) {
		enderecoRepository.enderecoExcluiEntidade(id.getId());				
		entidadeRepository.delete(id);
		return new ResponseEntity<String>("Entidade Exclu??da com Sucesso", HttpStatus.OK);

	}
	
	
	@PostMapping(value="salvar0001")
	@ResponseBody
	public ResponseEntity<Entidade>salvar0001(@RequestBody Entidade e){
		Entidade entidade = entidadeRepository.save(e);
		return new ResponseEntity<Entidade>(entidade,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "entidadeid/{id}")
	@ResponseBody
	public ResponseEntity<?> EntidadeID(@PathVariable("id") Long id) {
		
		Entidade e = entidadeRepository.findById(id).get();
		Endereco ec = new Endereco() ;
		ec = enderecoRepository.procuraEnderecoEntidade(id);
		ClienteEntidadeEndereco entidadeCompleta = new ClienteEntidadeEndereco();
		entidadeCompleta.setNome(e.getNome());
		entidadeCompleta.setCnpj(e.getCnpj());
		entidadeCompleta.setLogradouro(ec.getLogradouro());
		entidadeCompleta.setNumero(ec.getNumero());
		entidadeCompleta.setComplemento(ec.getComplemento());
		entidadeCompleta.setBairro(ec.getBairro());
		entidadeCompleta.setCep(ec.getCep());
		entidadeCompleta.setCidade(ec.getCidade());
		entidadeCompleta.setUf(ec.getUf());
		entidadeCompleta.setFk_idEntidade(ec.getFk_idEntidade());
		entidadeCompleta.setId(e.getId());
		entidadeCompleta.setEndId(ec.getId());
		System.out.println("OBJETO RETORNADO" + entidadeCompleta);
		return new ResponseEntity<ClienteEntidadeEndereco>(entidadeCompleta, HttpStatus.OK);
	}
	

}
