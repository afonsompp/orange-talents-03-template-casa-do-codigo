package br.com.casaDoCodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String title;
	@Column(nullable = false, length = 500)
	private String resume;
	@Column(columnDefinition = "TEXT")
	private String sumary;
	@Column(nullable = false)
	private BigDecimal price;
	@Column(nullable = false)
	private Integer numberOfPage;
	@Column(nullable = false, unique = true)
	private String isbn;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate publicationDate;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Category category;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Author author;

	public Book() {
	}

	public Book(String title, String resume, String sumary, BigDecimal price, Integer numberOfPage, String isbn,
			LocalDate publicationDate, Category category, Author author) {
		this.title = title;
		this.resume = resume;
		this.sumary = sumary;
		this.price = price;
		this.numberOfPage = numberOfPage;
		this.isbn = isbn;
		this.publicationDate = publicationDate;
		this.category = category;
		this.author = author;
	}

	public Long getId() {
		return id;
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

}
