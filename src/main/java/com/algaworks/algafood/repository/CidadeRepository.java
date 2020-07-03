package com.algaworks.algafood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.modelo.Cidade;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	/*public List<Cidade> listar();
	public Cidade buscar(Long id);
	public Cidade adicionar(Cidade cozinha);
	public void remove(Long id);
	*/
}
