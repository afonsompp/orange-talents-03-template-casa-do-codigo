package br.com.casaDoCodigo.controller.dto.author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.casaDoCodigo.Validation.Validator.UniqueEmailConstraint;
import br.com.casaDoCodigo.model.Author;

public class AuthorDto {

	@NotBlank
	private String name;
	@NotBlank
	@Email
	@UniqueEmailConstraint(message = "{email.unique}")
	private String email;
	@NotBlank
	@Size(max = 400)
	private String description;

	public AuthorDto() {
	}

	public AuthorDto(String name, String email, String description) {
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

	public Author parseToAuthor() {
		return new Author(this.name, this.email, this.description);
	}
}
