package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.algaworks.algafood.api.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.service.RestauranteService;
import com.algaworks.algafood.modelo.Cozinha;
import com.algaworks.algafood.modelo.Restaurante;
import com.algaworks.algafood.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private RestauranteService restauranteService;
	
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

	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
		try {
			restaurante = restauranteService.salvar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Restaurante> atualizar (@PathVariable Long restauranteId, 
			@RequestBody Restaurante restaurante) {
		Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);
		Optional<Restaurante> retorno = Optional.ofNullable(restauranteAtual);
		if(retorno.isPresent()) {
			BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
			restauranteService.salvar(restauranteAtual);
			return ResponseEntity.ok(restauranteAtual);

		}
		return ResponseEntity.notFound().build();
	}
}
