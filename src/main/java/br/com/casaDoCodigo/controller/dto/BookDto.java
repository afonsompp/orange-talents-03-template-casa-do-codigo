package br.com.casaDoCodigo.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.casaDoCodigo.Validation.UniqueFieldConstraint;
import br.com.casaDoCodigo.model.Book;
import br.com.casaDoCodigo.repository.AuthorRepository;
import br.com.casaDoCodigo.repository.CategoryRepository;

public class BookDto {
	@NotBlank
	@UniqueFieldConstraint(columnName = "title", model = Book.class)
	private String title;
	@NotBlank
	@Size(max = 500)
	private String resume;
	@NotBlank
	private String sumary;
	@Min(20)
	private BigDecimal price;
	@NotNull
	@Min(100)
	private Integer numberOfPage;
	@NotBlank
	private String isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate publicationDate;
	@NotNull
	private Long categoryId;
	@NotNull
	private Long authorId;

	public BookDto() {
	}

	public String getTitle() {
		return this.title;
	}

	public String getResume() {
		return this.resume;
	}

	public String getSumary() {
		return this.sumary;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public Integer getNumberOfPage() {
		return this.numberOfPage;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public LocalDate getPublicationDate() {
		return this.publicationDate;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public Long getAuthorId() {
		return this.authorId;
	}

	public Book parseToBook(AuthorRepository authorRepository, CategoryRepository categoryRepository) {
		var author = authorRepository.findById(this.authorId);
		var category = categoryRepository.findById(this.categoryId);

		if (!author.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
		}
		if (!category.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
		}

		return new Book(title, resume, sumary, price, numberOfPage, isbn, publicationDate, category.get(),
				author.get());

	}
}
