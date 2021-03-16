package br.com.casaDoCodigo.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.casaDoCodigo.model.Author;
import br.com.casaDoCodigo.model.Book;
import br.com.casaDoCodigo.model.Category;

public class DetailBookResponseDto {
	private Long id;
	private String title;
	private String resume;
	private String sumary;
	private BigDecimal price;
	private Integer numberOfPage;
	private String isbn;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate publicationDate;
	private Category category;
	private Author author;

	public DetailBookResponseDto() {
	}

	public DetailBookResponseDto(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
		this.resume = book.getResume();
		this.sumary = book.getSumary();
		this.price = book.getPrice();
		this.numberOfPage = book.getNumberOfPage();
		this.isbn = book.getIsbn();
		this.publicationDate = book.getPublicationDate();
		this.category = book.getCategory();
		this.author = book.getAuthor();
	}

	public Long getId() {
		return this.id;
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

	public Category getCategory() {
		return this.category;
	}

	public Author getAuthor() {
		return this.author;
	}

	public static List<AllBookResponseDto> parseToDto(Iterable<Book> books) {
		List<AllBookResponseDto> result = new ArrayList<>();
		books.forEach(b -> result.add(new AllBookResponseDto(b)));

		return result;
	}

}
