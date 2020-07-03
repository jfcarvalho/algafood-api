package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.api.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.modelo.Cozinha;
import com.algaworks.algafood.modelo.Restaurante;
import com.algaworks.algafood.repository.CozinhaRepository;
import com.algaworks.algafood.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar (Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		Optional<Cozinha> retorno = Optional.of(cozinha);
		if(!retorno.isPresent()) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe cozinha com código %d", cozinhaId));	
		}
		
		restaurante.setCozinha(cozinha);
		return restauranteRepository.adicionar(restaurante);
		
	}
}
