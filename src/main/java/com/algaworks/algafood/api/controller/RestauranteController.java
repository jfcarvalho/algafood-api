package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.modelo.Restaurante;
import com.algaworks.algafood.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.listar();
	}
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable("restauranteId") Long id) {
		Restaurante restaurante = restauranteRepository.buscar(id);
		Optional<Restaurante> retorno = Optional.ofNullable(restaurante);
		if(retorno.isPresent()) {
			return ResponseEntity.ok(restaurante);
		}
		
		return ResponseEntity.notFound().build();				
	}



}
