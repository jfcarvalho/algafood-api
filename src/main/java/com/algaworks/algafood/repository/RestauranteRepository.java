package com.algaworks.algafood.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.modelo.Restaurante;

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {

	/*
	 * Procura taxas entre um determinado intervalo
	 */
	
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	/*
	 * Retornando o primeiro resultado que contem nome e o id da cozinha
	 */
	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
	/*
	 * Retornando o primeiro resultado que contem nome 
	 */
	Optional<Restaurante> findFirstByNomeContaining(String nome);
	/*
	 * Retornando os 2 primeiros resultados
	 */
	List<Restaurante> findTop2ByNomeContaining(String nome);
	@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNome2(String nome, @Param("id") Long Cozinha);
}
