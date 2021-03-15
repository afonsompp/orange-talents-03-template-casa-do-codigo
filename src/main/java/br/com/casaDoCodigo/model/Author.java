package br.com.casaDoCodigo.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(length = 400, nullable = false)
	private String description;
	@Column(nullable = false)
	private Instant createAt;


	public Author() {
	}

	public Author(String name, String email, String description) {
		this.name = name;
		this.email = email;
		this.description = description;
		this.createAt = Instant.now();
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getDescription() {
		return this.description;
	}

	public Instant getCreateAt() {
		return this.createAt;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Author)) {
			return false;
		}
		Author author = (Author) o;
		return Objects.equals(id, author.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, createAt);
	}

}
