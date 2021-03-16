package br.com.casaDoCodigo.controller.dto;

import br.com.casaDoCodigo.model.Country;

public class CountryResponseDto {

	private Long id;
	private String name;

	public CountryResponseDto() {
	}

	public CountryResponseDto(Country country) {
		this.id = country.getId();
		this.name = country.getName();
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

}
