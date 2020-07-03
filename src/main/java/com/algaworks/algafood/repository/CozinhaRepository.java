package com.algaworks.algafood.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.modelo.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
	//public List<Cozinha> listar();
	//public List<Cozinha> consultarPorNomeSemSJPA(String nome);
	//public Cozinha buscar(Long id);
	//public Cozinha adicionar(Cozinha cozinha);
	//public void remove(Long id);
	
}
