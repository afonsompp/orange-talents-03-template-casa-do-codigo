package br.com.casaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casaDoCodigo.controller.dto.AuthorDto;
import br.com.casaDoCodigo.repository.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	private final AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@PostMapping
	public ResponseEntity<AuthorDto> saveAuthor(@RequestBody @Valid final AuthorDto authorDto) {
		var author = authorRepository.save(authorDto.parseToAuthor());
		var response = new AuthorDto(author);
		return ResponseEntity.ok(response);
	}

}
