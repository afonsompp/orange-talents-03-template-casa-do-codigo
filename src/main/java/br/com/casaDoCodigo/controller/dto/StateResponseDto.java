package br.com.casaDoCodigo.controller.dto;

import br.com.casaDoCodigo.model.Country;
import br.com.casaDoCodigo.model.State;

public class StateResponseDto {
	private Long id;
	private String name;
	private Country country;

	public StateResponseDto() {
	}

	public StateResponseDto(State state) {
		this.id = state.getId();
		this.name = state.getName();
		this.country = state.getCountry();
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Country getCountry() {
		return this.country;
	}

}
