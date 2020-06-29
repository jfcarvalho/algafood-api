package com.algaworks.algafood.api.modelo;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.algaworks.algafood.modelo.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@JacksonXmlRootElement(localName = "cozinhas")
@Data
public class CozinhasXMLWrapper {
	
	@JsonProperty("cozinha")
	@JacksonXmlElementWrapper(useWrapping = false)
	@NotNull
	private List<Cozinha> cozinhas;
	
	public CozinhasXMLWrapper(List<Cozinha> cozinhas)
	{
		this.cozinhas = cozinhas;
	}

}
