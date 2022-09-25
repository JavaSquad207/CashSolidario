package com.entra21.cashsolidario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.cashsolidario.entity.Endereco;
import com.entra21.cashsolidario.repository.EnderecoRepository;

@RestController
@RequestMapping(value="/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@PostMapping(value="salvar")
	@ResponseBody
	public ResponseEntity<Endereco>salvar(@RequestBody Endereco e){
		Endereco endereco = enderecoRepository.save(e);
		
		return new ResponseEntity<Endereco>(endereco,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Endereco>>listaEndereco(){
		List<Endereco> endereco = enderecoRepository.findAll();
		return new ResponseEntity<List<Endereco>>(endereco, HttpStatus.OK);
	}

}