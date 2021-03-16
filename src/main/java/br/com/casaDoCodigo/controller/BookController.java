package br.com.casaDoCodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casaDoCodigo.controller.dto.AllBookResponseDto;
import br.com.casaDoCodigo.controller.dto.BookDto;
import br.com.casaDoCodigo.controller.dto.DetailBookResponseDto;
import br.com.casaDoCodigo.repository.AuthorRepository;
import br.com.casaDoCodigo.repository.BookRepository;
import br.com.casaDoCodigo.repository.CategoryRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	private final CategoryRepository categoryRepository;

	public BookController(BookRepository bookRepository, AuthorRepository authorRepository,
			CategoryRepository categoryRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.categoryRepository = categoryRepository;
	}

	@PostMapping
	public ResponseEntity<DetailBookResponseDto> save(@RequestBody @Valid BookDto bookDto) {

		var book = bookDto.parseToBook(authorRepository, categoryRepository);
		var savedBook = bookRepository.save(book);

		return ResponseEntity.ok(new DetailBookResponseDto(savedBook));
	}

	@GetMapping
	public List<AllBookResponseDto> allBooks() {
		var books = bookRepository.findAll();
		var response = AllBookResponseDto.parseToDto(books);

		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetailBookResponseDto> getById(@PathVariable("id") Long id) {
		var book = bookRepository.findById(id);

		if (!book.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new DetailBookResponseDto(book.get()));
	}

}
