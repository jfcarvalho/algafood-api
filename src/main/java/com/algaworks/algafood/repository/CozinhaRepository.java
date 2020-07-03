package com.algaworks.algafood.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cozinha;

@Component
public interface CozinhaRepository {
	public List<Cozinha> listar();
	public List<Cozinha> consultarPorNomeSemSJPA(String nome);
	public Cozinha buscar(Long id);
	public Cozinha adicionar(Cozinha cozinha);
	public void remove(Long id);
	
}
