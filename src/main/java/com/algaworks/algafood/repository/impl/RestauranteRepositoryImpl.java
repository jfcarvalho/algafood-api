package com.algaworks.algafood.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.algaworks.algafood.modelo.Restaurante;
import com.algaworks.algafood.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> listar() {
		return manager.createQuery("from Restaurante", Restaurante.class)
			.getResultList();	
	}
	
	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	@Override
	@Transactional
	public Restaurante adicionar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
	
	@Override
	@Transactional
	public void remove(Restaurante restaurante) {
		restaurante = buscar(restaurante.getId());
		Optional<Restaurante> retorno = Optional.ofNullable(restaurante);
		if(retorno.isPresent()) {
			manager.remove(restaurante);
		}
	}

}
