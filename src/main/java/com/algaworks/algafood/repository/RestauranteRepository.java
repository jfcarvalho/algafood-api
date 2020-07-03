package com.algaworks.algafood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

	
	/*public List<Restaurante> listar();
	public Restaurante buscar(Long id);
	public Restaurante adicionar(Restaurante cozinha);
	public void remove(Restaurante cozinha);
	*/
}
