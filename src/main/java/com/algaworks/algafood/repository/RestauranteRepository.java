package com.algaworks.algafood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.modelo.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

	
	/*public List<Restaurante> listar();
	public Restaurante buscar(Long id);
	public Restaurante adicionar(Restaurante cozinha);
	public void remove(Restaurante cozinha);
	*/
}
