package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.modelo.CozinhasXMLWrapper;
import com.algaworks.algafood.modelo.Cozinha;
import com.algaworks.algafood.repository.CozinhaRepository;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}
	
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
		Cozinha cozinha = cozinhaRepository.buscar(id);
		//return ResponseEntity.status(HttpStatus.OK).body(cozinha);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, "http://localhost:8081/cozinhas");
		
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.headers(headers)
				.build();
				
	}

	@GetMapping(value="/cozinhasWrapper", produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXMLWrapper listarXml() {
		return new CozinhasXMLWrapper(cozinhaRepository.listar());
	}
}
