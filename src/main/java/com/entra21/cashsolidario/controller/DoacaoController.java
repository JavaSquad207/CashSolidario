package com.entra21.cashsolidario.controller;

import java.util.List;
import java.util.Optional;

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
import com.entra21.cashsolidario.entity.Doacao;
import com.entra21.cashsolidario.repository.CampanhaRepository;
import com.entra21.cashsolidario.repository.DoacaoRepository;

@RestController
@RequestMapping(value ="/doacao")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class DoacaoController {
	@Autowired
	private DoacaoRepository doacaoRepository;
	
	@Autowired
	private CampanhaRepository campanhaRepository;
	
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Doacao> salvar(@RequestBody Doacao d) {
		if (d.getValor()<0) {
			d.setFkIdCliente((long) 0);
		}
		Doacao doacao = doacaoRepository.saveAndFlush(d);
		Optional<Campanha> campanhaOptional= campanhaRepository.findById(d.getFkIdCampanha());
		if(campanhaOptional.isPresent()) {
		Campanha campanha = campanhaOptional.get();		
		campanha.setId(d.getFkIdCampanha());
		campanha.setSomaCampanha(campanha.getSomaCampanha()+d.getValor());
		System.out.println(d.getValor());
		campanhaRepository.saveAndFlush(campanha);
		}
				
		return new ResponseEntity<Doacao>(doacao, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Doacao>> listaDoacao() {
		List<Doacao> doacao = doacaoRepository.findAll();
		return new ResponseEntity<List<Doacao>>(doacao, HttpStatus.OK);
	}
	
	@GetMapping(value = "delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Doacao id) {
		doacaoRepository.delete(id);
		return new ResponseEntity<String>("Doacao Exclu??da com Sucesso", HttpStatus.OK);
	}
	
	@GetMapping(value = "doacaoid/{id}")
	@ResponseBody
	public ResponseEntity<Doacao> DoacaoId(@PathVariable("id") Long id) {
		Doacao d = doacaoRepository.findById(id).get();
		return new ResponseEntity<Doacao>(d, HttpStatus.OK);
	}
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<Doacao> atualizar(@RequestBody Doacao d) {
		Doacao doacao = doacaoRepository.saveAndFlush(d);
		return new ResponseEntity<Doacao>(doacao, HttpStatus.OK);
	}

	@GetMapping(value = "atualizargen")
	@ResponseBody
	public ResponseEntity<?> atualizarGen(@RequestBody Doacao d) {
		if (d.getId() == null) {
			return new ResponseEntity<String>("Registro Inv??lido", HttpStatus.OK);
		}
		Doacao doacao = doacaoRepository.saveAndFlush(d);
		return new ResponseEntity<Doacao>(doacao, HttpStatus.OK);
	}
	
	@PostMapping(value = "salvar0001")
	@ResponseBody
	public ResponseEntity<Doacao> salvar00001(@RequestBody Doacao d) {
		Doacao doacao = doacaoRepository.save(d);
		return new ResponseEntity<Doacao>(doacao, HttpStatus.CREATED);
	}
	
}
