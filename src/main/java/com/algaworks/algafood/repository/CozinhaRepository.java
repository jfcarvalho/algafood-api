package com.algaworks.algafood.repository;

import java.util.List;

import com.algaworks.algafood.modelo.Cozinha;

public interface CozinhaRepository {
	public List<Cozinha> listar();
	public Cozinha buscar(Long id);
	public Cozinha adicionar(Cozinha cozinha);
	public void remove(Long id);
	
}
