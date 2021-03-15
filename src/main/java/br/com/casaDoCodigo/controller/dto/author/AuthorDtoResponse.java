package br.com.casaDoCodigo.controller.dto.author;

import java.util.List;
import java.util.stream.Collectors;

import br.com.casaDoCodigo.model.Author;

public class AuthorDtoResponse {

	private String name;
	private String email;
	private String description;

	public AuthorDtoResponse(Author author) {
		this.name = author.getName();
		this.email = author.getEmail();
		this.description = author.getDescription();
	}


	public AuthorDtoResponse(String name, String email, String description) {
		this.name = name;
		this.email = email;
		this.description = description;
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

	public static List<AuthorDtoResponse> parseToAuthorDto(List<Author> authors) {
		return authors.stream().map(AuthorDtoResponse::new).collect(Collectors.toList());
	}
}
