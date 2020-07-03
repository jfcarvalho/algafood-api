package com.algaworks.algafood.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.modelo.Cidade;

@Component
public class CidadeRepositoryImpl  {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Deprecated
	//@Override
	public List<Cidade> listar() {
		return manager.createQuery("from Cidade", Cidade.class)
			.getResultList();	
	}
	
	@Deprecated
	//@Override
	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}
	
	@Deprecated
	//@Override
	@Transactional
	public Cidade adicionar(Cidade cidade) {
		return manager.merge(cidade);
	}
	
	@Deprecated
	//@Override
	@Transactional
	public void remove(Long id) {
		Cidade cidade = buscar(id);
		Optional<Cidade> retorno = Optional.ofNullable(cidade);
		if(retorno.isPresent()) {
			manager.remove(cidade);
		}
		else {
			throw new EmptyResultDataAccessException(1);
		}
	}

}
