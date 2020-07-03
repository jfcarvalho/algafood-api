package com.algaworks.algafood.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("cidade")
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Cidade {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("titulo")
	@Column(nullable= false)
	private String nome;
	
	@ManyToOne
	private Estado estado;
	
	

}
