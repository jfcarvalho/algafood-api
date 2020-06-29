package com.algaworks.algafood.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("cozinha")
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Cozinha {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	//@JsonIgnore
	@JsonProperty("titulo")
	@Column(nullable= false)
	private String nome;

	
		

}
