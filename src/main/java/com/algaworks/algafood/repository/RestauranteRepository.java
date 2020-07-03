package com.algaworks.algafood.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.modelo.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

	/*
	 * Procura taxas entre um determinado inteervalo
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
}
