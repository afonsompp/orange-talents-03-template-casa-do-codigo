package br.com.casaDoCodigo.controller.dto;

import br.com.casaDoCodigo.model.Author;

public class AuthorResponseDto {

	private Long id;
	private String name;
	private String email;
	private String description;

	public AuthorResponseDto() {
	}

	public AuthorResponseDto(Author author) {
		this.id = author.getId();
		this.name = author.getName();
		this.email = author.getEmail();
		this.description = author.getDescription();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getDescription() {
		return this.description;
	}
}
