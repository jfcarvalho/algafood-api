package com.algaworks.algafood.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algafood.modelo.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}