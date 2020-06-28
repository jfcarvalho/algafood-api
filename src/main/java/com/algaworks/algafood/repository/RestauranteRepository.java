package com.algaworks.algafood.repository;

import java.util.List;

import com.algaworks.algafood.modelo.Restaurante;

public interface RestauranteRepository {

	
	public List<Restaurante> listar();
	public Restaurante buscar(Long id);
	public Restaurante adicionar(Restaurante cozinha);
	public void remove(Restaurante cozinha);
}
