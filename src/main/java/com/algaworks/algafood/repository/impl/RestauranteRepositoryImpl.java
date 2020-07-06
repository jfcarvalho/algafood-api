package com.algaworks.algafood.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.algaworks.algafood.modelo.Restaurante;
import com.algaworks.algafood.repository.RestauranteRepositoryQueries;


@Component
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal)
	{
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
		Root<Restaurante> root = criteria.from(Restaurante.class);
		var predicates = new ArrayList<Predicate>();
		if(StringUtils.hasText(nome)) {
			predicates.add(builder.like(root.get("Nome"), "%"+nome+"%"));
		}
		if(taxaFreteInicial != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
		}
		if(taxaFreteFinal != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
		}
		
		
		
		criteria.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Restaurante> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}
	
	@Deprecated
	//@Override
	public List<Restaurante> findOld(String nome,
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) 
	{
		var jpql = "from Restaurante where nome like :nome "
				+ "and taxaFrete between :taxaInicial and :taxaFinal";
		return manager.createQuery(jpql, Restaurante.class)
				.setParameter("nome", "%" + nome + "%")
				.setParameter("taxaInicial", taxaFreteInicial)
				.setParameter("taxaFinal", taxaFreteFinal)
				.getResultList();
				
	}
	
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
