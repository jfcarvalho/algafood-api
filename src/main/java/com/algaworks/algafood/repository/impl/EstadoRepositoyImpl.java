package com.algaworks.algafood.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.modelo.Estado;
import com.algaworks.algafood.repository.EstadoRepository;

@Component
public class EstadoRepositoyImpl implements EstadoRepository {
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> listar() {
		return manager.createQuery("from Estado", Estado.class)
			.getResultList();	
	}
	
	@Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}
	
	@Override
	@Transactional
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}
	
	@Override
	@Transactional
	public void remove(Estado estado) {
		estado = buscar(estado.getId());
		manager.remove(estado);
	}

}
