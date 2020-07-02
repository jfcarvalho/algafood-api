package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.api.exception.EntidadeEmUsoException;
import com.algaworks.algafood.api.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.modelo.Cozinha;
import com.algaworks.algafood.repository.CozinhaRepository;

@Service
public class CozinhaService {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.adicionar(cozinha);
	}
	
	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.remove(cozinhaId);
		}
		catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
		}
		catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
		}
	}
	
	
}
