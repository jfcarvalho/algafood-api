package com.algaworks.algafood.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.modelo.Cidade;
import com.algaworks.algafood.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cidade> listar() {
		return manager.createQuery("from Cidade", Cidade.class)
			.getResultList();	
	}
	
	@Override
	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}
	
	@Override
	@Transactional
	public Cidade adicionar(Cidade cidade) {
		return manager.merge(cidade);
	}
	
	@Override
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
