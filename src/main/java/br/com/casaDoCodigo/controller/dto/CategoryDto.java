package br.com.casaDoCodigo.controller.dto;

import javax.validation.constraints.NotBlank;

import br.com.casaDoCodigo.Validation.UniqueFieldConstraint;
import br.com.casaDoCodigo.model.Category;

public class CategoryDto {

	@NotBlank
	@UniqueFieldConstraint(message = "{category.unique}", columnName = "name", model = Category.class)
	private String name;

	public CategoryDto() {
	}

	public CategoryDto(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Category parseToCategory() {
		return new Category(name);
	}
}
