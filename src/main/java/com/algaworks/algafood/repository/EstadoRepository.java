package com.algaworks.algafood.repository;

import java.util.List;

import com.algaworks.algafood.modelo.Estado;

public interface EstadoRepository {
	public List<Estado> listar();
	public Estado buscar(Long id);
	public Estado adicionar(Estado estado);
	public void remove(Estado estado);
	
}
