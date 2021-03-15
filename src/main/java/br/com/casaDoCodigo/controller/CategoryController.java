package br.com.casaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casaDoCodigo.controller.dto.CategoryDto;
import br.com.casaDoCodigo.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@PostMapping()
	public ResponseEntity<CategoryDto> postMethodName(@RequestBody @Valid CategoryDto categoryDto) {

		var category = categoryRepository.save(categoryDto.parseToCategory());

		return ResponseEntity.ok(new CategoryDto(category));
	}

}
