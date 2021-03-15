package br.com.casaDoCodigo.controller.dto.category;

import javax.validation.constraints.NotBlank;

import br.com.casaDoCodigo.Validation.Validator.UniqueCategoryConstraint;
import br.com.casaDoCodigo.model.Category;

public class CategoryDto {

	@NotBlank
	@UniqueCategoryConstraint
	private String name;

	public CategoryDto() {
	}

	public CategoryDto(String name) {
		this.name = name;
	}

	public CategoryDto(Category category) {
		this.name = category.getName();
	}

	public String getName() {
		return name;
	}

	public Category parseToCategory() {
		return new Category(name);
	}

}
