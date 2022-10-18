package com.entra21.cashsolidario.controller;

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

import com.entra21.cashsolidario.entity.Campanha;
import com.entra21.cashsolidario.repository.CampanhaRepository;

@RestController
@RequestMapping(value="/campanha")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CampanhaController {

	@Autowired
	private CampanhaRepository campanhaRepository;
	
	@PostMapping(value="salvar")
	@ResponseBody
	public ResponseEntity<Campanha>salvar(@RequestBody Campanha c){
		Campanha campanha = campanhaRepository.saveAndFlush(c);
		
		return new ResponseEntity<Campanha>(campanha, HttpStatus.CREATED);
	}
	
	@GetMapping(value="listartodos")
	@ResponseBody
	public ResponseEntity<List<Campanha>>listaCampanha(){
		List<Campanha> campanha = campanhaRepository.findAll();
		
		return new ResponseEntity<List<Campanha>>(campanha, HttpStatus.OK);
	}
	
	@GetMapping(value = "delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Campanha id) {
		campanhaRepository.delete(id);
		return new ResponseEntity<String>("Campanha Excluída com Sucesso", HttpStatus.OK);
	}
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Campanha c){
		Campanha cam = idExistente(c.getId());
		
		if(cam.getId( )== null) {
			return new ResponseEntity<String>("ID não localizado", HttpStatus.OK);
		}
		Campanha fabricante = campanhaRepository.saveAndFlush(c);
		return new ResponseEntity<Campanha>(fabricante, HttpStatus.OK);		
	}
	@GetMapping(value = "campanhaid/{id}")
	@ResponseBody	
	public  Campanha idExistente(@PathVariable("id")Long id) {
		Campanha c = campanhaRepository.findById(id).get();
		return c;
	}
	
	@PostMapping(value="salvar001")
	@ResponseBody
	public ResponseEntity<Campanha>salvar001(@RequestBody Campanha c){
		Campanha campanha = campanhaRepository.save(c);
		
		return new ResponseEntity<Campanha>(campanha, HttpStatus.CREATED);
	}
}
