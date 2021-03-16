package br.com.casaDoCodigo.controller.dto;

import br.com.casaDoCodigo.model.Category;

public class CategoryResponseDto {

	private Long id;
	private String name;

	public CategoryResponseDto() {
	}

	public CategoryResponseDto(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
