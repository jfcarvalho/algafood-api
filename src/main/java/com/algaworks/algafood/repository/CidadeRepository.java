package com.algaworks.algafood.repository;

import java.util.List;


import com.algaworks.algafood.modelo.Cidade;



public interface CidadeRepository {

	public List<Cidade> listar();
	public Cidade buscar(Long id);
	public Cidade adicionar(Cidade cozinha);
	public void remove(Long id);
	
}
