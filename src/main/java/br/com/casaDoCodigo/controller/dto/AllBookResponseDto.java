package br.com.casaDoCodigo.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.casaDoCodigo.model.Book;

public class AllBookResponseDto {
	private Long id;
	private String title;

	public AllBookResponseDto() {
	}

	public AllBookResponseDto(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
	}


	public Long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}
	public static List<AllBookResponseDto> parseToDto(Iterable<Book> books) {
		List<AllBookResponseDto> result = new ArrayList<>();
		books.forEach(b -> result.add(new AllBookResponseDto(b)));

		return result;
	}

}
