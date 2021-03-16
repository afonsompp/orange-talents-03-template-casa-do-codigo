package br.com.casaDoCodigo.controller.dto;

import javax.validation.constraints.NotBlank;

import br.com.casaDoCodigo.Validation.UniqueFieldConstraint;
import br.com.casaDoCodigo.model.Country;

public class CountryDto {

	@UniqueFieldConstraint(columnName = "name", model = Country.class)
	@NotBlank
	private String name;

	public CountryDto() {
	}

	public String getName() {
		return name;
	}

	public Country parseToCountry() {
		return new Country(name);
	}

}
