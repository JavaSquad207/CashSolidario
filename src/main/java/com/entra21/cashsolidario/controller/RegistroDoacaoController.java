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

import com.entra21.cashsolidario.entity.RegistroDoacao;
import com.entra21.cashsolidario.repository.RegistroDoacaoRepository;

@RestController
@RequestMapping(value="/registrodoacao")
public class RegistroDoacaoController {
	
	@Autowired
	private RegistroDoacaoRepository registroDoacaoRepository;
	
	@PostMapping(value="salvar")
	@ResponseBody
	public ResponseEntity<RegistroDoacao>salvar(@RequestBody RegistroDoacao rd){
		RegistroDoacao registroDoacao = registroDoacaoRepository.save(rd);
		return new ResponseEntity<RegistroDoacao>(registroDoacao, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<RegistroDoacao>>listaEndereco(){
		List<RegistroDoacao> registroDoacao = registroDoacaoRepository.findAll();
		return new ResponseEntity<List<RegistroDoacao>>(registroDoacao, HttpStatus.OK);
	}

}