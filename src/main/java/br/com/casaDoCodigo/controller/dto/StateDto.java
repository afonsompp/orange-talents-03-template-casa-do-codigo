package br.com.casaDoCodigo.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.casaDoCodigo.Validation.UniqueFieldConstraint;
import br.com.casaDoCodigo.model.State;
import br.com.casaDoCodigo.repository.CountryRepository;

public class StateDto {
	@NotBlank
	@UniqueFieldConstraint(columnName = "name", model = State.class, foreignKeyName = "country_id")
	private String name;
	@NotNull
	private Long countryId;

	public StateDto() {
	}

	public String getName() {
		return name;
	}

	public Long getCountryId() {
		return countryId;
	}

	public State parseToState(CountryRepository countryRepository) {
		var country = countryRepository.findById(this.countryId);
		if (country.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found");
		}
		return new State(name, country.get());
	}
}
