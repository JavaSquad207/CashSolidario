package com.entra21.cashsolidario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entra21.cashsolidario.entity.Campanha;
import com.entra21.cashsolidario.entity.Repasse;
import com.entra21.cashsolidario.repository.CampanhaRepository;
import com.entra21.cashsolidario.repository.RepasseRepository;

public class RepasseController {
	@Autowired
	private RepasseRepository repasseRepository;
	
	@PostMapping(value="salvar")
	@ResponseBody
	public ResponseEntity<Repasse>salvar(@RequestBody Repasse r){
		Repasse repasse = repasseRepository.save(r);
		
		return new ResponseEntity<Repasse>(repasse, HttpStatus.CREATED);
	}
	
	@GetMapping(value="listartodos")
	@ResponseBody
	public ResponseEntity<List<Repasse>>listaRepasse(){
		List<Repasse> repasse = repasseRepository.findAll();
		
		return new ResponseEntity<List<Repasse>>(repasse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id){
		repasseRepository.deleteById(id);
		return new ResponseEntity<String>("Fabricante removido com sucesso.", HttpStatus.OK);
	}
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Repasse r){
		Repasse rep = idExistente(r.getIdRepasse());
		
		if(rep.getIdRepasse( )== null) {
			return new ResponseEntity<String>("ID não localizado", HttpStatus.OK);
		}
		Repasse fabricante = repasseRepository.saveAndFlush(r);
		return new ResponseEntity<Repasse>(fabricante, HttpStatus.OK);		
	}
	
	public  Repasse idExistente(Long id) {
		Repasse r = repasseRepository.findById(id).get();
		return r;
	}
}
