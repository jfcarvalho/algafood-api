package com.algaworks.algafood.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.modelo.Estado;

@Component
public class EstadoRepositoyImpl  {
	@PersistenceContext
	private EntityManager manager;
	
	@Deprecated
	//@Override
	public List<Estado> listar() {
		return manager.createQuery("from Estado", Estado.class)
			.getResultList();	
	}
	
	@Deprecated
	//@Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}
	
	@Deprecated
	//@Override
	@Transactional
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}
	
	@Deprecated
	//@Override
	@Transactional
	public void remove(Estado estado) {
		estado = buscar(estado.getId());
		manager.remove(estado);
	}

}
