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

import com.entra21.cashsolidario.entity.Campanha;
import com.entra21.cashsolidario.repository.CampanhaRepository;

@RestController
@RequestMapping(value="/campanha")
public class CampanhaController {

	@Autowired
	private CampanhaRepository campanhaRepository;
	
	@PostMapping(value="salvar")
	@ResponseBody
	public ResponseEntity<Campanha>salvar(@RequestBody Campanha c){
		Campanha campanha = campanhaRepository.save(c);
		
		return new ResponseEntity<Campanha>(campanha, HttpStatus.CREATED);
	}
	
	@GetMapping(value="listartodos")
	@ResponseBody
	public ResponseEntity<List<Campanha>>listaCampanha(){
		List<Campanha> campanha = campanhaRepository.findAll();
		
		return new ResponseEntity<List<Campanha>>(campanha, HttpStatus.OK);
	}
}
