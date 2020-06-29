package com.algaworks.algafood.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.modelo.Cozinha;
import com.algaworks.algafood.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> listar() {
		return manager.createQuery("from Cozinha", Cozinha.class)
			.getResultList();	
	}
	
	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Override
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Override
	@Transactional
	public void remove(Cozinha cozinha) {
		cozinha = buscar(cozinha.getId());
		Optional<Cozinha> retorno = Optional.ofNullable(cozinha);
		if(retorno.isPresent()) {
			manager.remove(cozinha);
		}
	}
}
