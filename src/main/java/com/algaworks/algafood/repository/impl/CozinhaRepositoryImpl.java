package com.algaworks.algafood.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.algaworks.algafood.modelo.Cozinha;


public class CozinhaRepositoryImpl {
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping("/cozinhas/por-nome")
	//@Override
	public List<Cozinha> consultarPorNomeSemSJPA(@RequestParam("nome") String nome) {
		return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
				.setParameter("%" + "nome" + "%", nome)
				.getResultList();
	}
	
	@Deprecated
	//@Override
	public List<Cozinha> listar() {
		return manager.createQuery("from Cozinha", Cozinha.class)
			.getResultList();	
	}
	@Deprecated
	//@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	@Deprecated
	//@Override
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Deprecated
	//@Override
	@Transactional
	public void remove(Long id) {
		Cozinha cozinha = buscar(id);
		Optional<Cozinha> retorno = Optional.ofNullable(cozinha);
		if(retorno.isPresent()) {
			manager.remove(cozinha);
		}
		else {
			throw new EmptyResultDataAccessException(1);
		}
	}
	
	
	
	
}
