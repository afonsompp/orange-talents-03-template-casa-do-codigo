package br.com.casaDoCodigo.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.casaDoCodigo.controller.dto.author.AuthorDto;
import br.com.casaDoCodigo.controller.dto.author.AuthorDtoResponse;
import br.com.casaDoCodigo.repository.AuthorRepository;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	private final AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@PostMapping
	public ResponseEntity<AuthorDtoResponse> saveAuthor(@RequestBody @Valid final AuthorDto authorDto) {
		var author = authorRepository.save(authorDto.parseToAuthor());
		var response = new AuthorDtoResponse(author);
		return ResponseEntity.ok(response);
	}

}
