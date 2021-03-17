package br.com.casaDoCodigo.controller.dto;

import br.com.casaDoCodigo.model.Customer;

public class CustomerResponseDto {
	private Long id;
	private String name;

	public CustomerResponseDto(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
	}

	public CustomerResponseDto() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
