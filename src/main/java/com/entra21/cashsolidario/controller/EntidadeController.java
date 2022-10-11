package com.entra21.cashsolidario.controller;

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

import com.entra21.cashsolidario.entity.Endereco;
import com.entra21.cashsolidario.entity.Entidade;
import com.entra21.cashsolidario.repository.EntidadeRepository;

@RestController
@RequestMapping(value="/entidade")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class EntidadeController {
	
	@Autowired
	private EntidadeRepository entidadeRepository;
	
	@PostMapping(value="salvar")
	@ResponseBody
	public ResponseEntity<Entidade>salvar(@RequestBody Entidade e){
		Entidade entidade = entidadeRepository.save(e);
		return new ResponseEntity<Entidade>(entidade,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Entidade>>listaEntidade(){
		List<Entidade> entidade = entidadeRepository.findAll();
		return new ResponseEntity<List<Entidade>>(entidade, HttpStatus.OK);
	}
	
	@GetMapping(value = "entidadeid/{id}")
	@ResponseBody
	public ResponseEntity<Entidade> EntidadeID(@PathVariable("id") Long id) {
		Entidade e = entidadeRepository.findById(id).get();
		return new ResponseEntity<Entidade>(e, HttpStatus.OK);
	}
	
//	@GetMapping(value = "/enderecoporcliente/{id}")
//	@ResponseBody
//	public ResponseEntity<List<Endereco>> enderecoCli(@PathVariable("id") Long id) {
//		List<Endereco> e = enderecoRepository.findByIdCli(id);
//		return new ResponseEntity<List<Endereco>>(e, HttpStatus.OK);
//	}
	
	@GetMapping(value = "delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Entidade id) {
		entidadeRepository.delete(id);
		return new ResponseEntity<String>("Entidade Excluída com Sucesso", HttpStatus.OK);

	}
	

}
