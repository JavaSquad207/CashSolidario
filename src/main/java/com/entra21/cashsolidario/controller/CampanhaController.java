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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@DeleteMapping(value = "delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id){
		campanhaRepository.deleteById(id);
		return new ResponseEntity<String>("Fabricante removido com sucesso.", HttpStatus.OK);
	}
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Campanha c){
		Campanha cam = idExistente(c.getIdCampanha());
		
		if(cam.getIdCampanha( )== null) {
			return new ResponseEntity<String>("ID não localizado", HttpStatus.OK);
		}
		Campanha fabricante = campanhaRepository.saveAndFlush(c);
		return new ResponseEntity<Campanha>(fabricante, HttpStatus.OK);		
	}
	
	public  Campanha idExistente(Long id) {
		Campanha c = campanhaRepository.findById(id).get();
		return c;
	}
}
