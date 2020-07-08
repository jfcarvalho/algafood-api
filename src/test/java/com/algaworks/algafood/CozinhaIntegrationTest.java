package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import com.algaworks.algafood.api.exception.EntidadeEmUsoException;
import com.algaworks.algafood.api.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.service.CozinhaService;
import com.algaworks.algafood.modelo.Cozinha;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CozinhaIntegrationTest {

	@Autowired
	private CozinhaService cozinhaService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testarCadastroCozinhaComSucesso() {
		//cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
		//ação
		novaCozinha = cozinhaService.salvar(novaCozinha);
		
		//validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}
	
	@Test(expected = DataIntegrityViolationException.class)
	public void deveFalharAoCadastrarCozinha_QuandoSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		novaCozinha = cozinhaService.salvar(novaCozinha);
		
	}
	@Test(expected = EntidadeEmUsoException.class)
	public void deveFalhar_QuandoEcluirCozinhaEmUso() {
		cozinhaService.excluir(1L);
	}
	@Test(expected = EntidadeNaoEncontradaException.class)
	public void deveFalhar_QuandoEcluirCozinhaInexistente() {
		cozinhaService.excluir(100L);
	}
	
}
