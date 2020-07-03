package com.algaworks.algafood.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.algaworks.algafood.modelo.Restaurante;


@Component
public class RestauranteRepositoryImpl {

	@PersistenceContext
	private EntityManager manager;
	
	@Deprecated
	//@Override
	public List<Restaurante> listar() {
		return manager.createQuery("from Restaurante", Restaurante.class)
			.getResultList();	
	}
	
	@Deprecated
	//@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	@Deprecated
	//@Override
	@Transactional
	public Restaurante adicionar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
	
	@Deprecated
	//@Override
	@Transactional
	public void remove(Restaurante restaurante) {
		restaurante = buscar(restaurante.getId());
		Optional<Restaurante> retorno = Optional.ofNullable(restaurante);
		if(retorno.isPresent()) {
			manager.remove(restaurante);
		}
	}

}
