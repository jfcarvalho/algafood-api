package com.algaworks.algafood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.modelo.Estado;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
//	public List<Estado> listar();
//	public Estado buscar(Long id);
//	public Estado adicionar(Estado estado);
//	public void remove(Estado estado);
	
}
