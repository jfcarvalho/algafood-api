package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.exception.EntidadeEmUsoException;
import com.algaworks.algafood.api.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.service.CidadeService;
import com.algaworks.algafood.modelo.Cidade;
import com.algaworks.algafood.repository.CidadeRepository;


@RestController
@RequestMapping("/cidades")
public class CidadeController {
		
		@Autowired
		private CidadeRepository cidadeRepository;
		
		@Autowired
		private CidadeService cidadeService;
		
		@GetMapping
		public List<Cidade> listar() {
			return cidadeRepository.listar();
		}
		
		@GetMapping("/{cidadeId}")
		public ResponseEntity<Cidade> buscar(@PathVariable("cidadeId") Long id) {
			Cidade cidade = cidadeRepository.buscar(id);
			Optional<Cidade> retorno = Optional.ofNullable(cidade);
			if(retorno.isPresent()) {
				return ResponseEntity.ok(cidade);
			}
			
			return ResponseEntity.notFound().build();				
		}

		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Cidade adicionar(@RequestBody Cidade cidade) {
			return cidadeService.salvar(cidade);
		}
		
		@PutMapping("/{cidadeId}")
		public ResponseEntity<Cidade> atualizar (@PathVariable Long cidadeId, 
				@RequestBody Cidade cidade) {
			Cidade cidadeAtual = cidadeRepository.buscar(cidadeId);
			Optional<Cidade> retorno = Optional.ofNullable(cidadeAtual);
			if(retorno.isPresent()) {
				BeanUtils.copyProperties(cidade, cidadeAtual, "id");
				cidadeService.salvar(cidadeAtual);
				return ResponseEntity.ok(cidadeAtual);

			}
			return ResponseEntity.notFound().build();
		}
		
		@DeleteMapping("/{cidadeId}")
		public ResponseEntity<Cidade> remover(@PathVariable Long cidadeId) {
			try {	
				cidadeService.excluir(cidadeId);
			} catch (EntidadeNaoEncontradaException e) {
				return ResponseEntity.notFound().build();
			}
			catch (EntidadeEmUsoException e) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
				return ResponseEntity.notFound().build();
		}

}
