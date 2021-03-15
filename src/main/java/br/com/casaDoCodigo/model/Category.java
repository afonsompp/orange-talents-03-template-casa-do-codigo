package br.com.casaDoCodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;


	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Long getId() {
		return this.id;
	}


}
