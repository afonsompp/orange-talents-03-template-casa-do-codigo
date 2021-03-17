package br.com.casaDoCodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String document;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false, unique = true)
	private String complement;
	@Column(nullable = false, unique = true)
	private String city;
	@ManyToOne
	private State state;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Country country;

	public Customer() {
	}

	public Customer(String name, String lastName, String email, String document, String phone, String address,
			String complement, String city, State state, Country country) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.document = document;
		this.phone = phone;
		this.address = address;
		this.complement = complement;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getDocument() {
		return this.document;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAddress() {
		return this.address;
	}

	public String getComplement() {
		return this.complement;
	}

	public String getCity() {
		return this.city;
	}

	public State getState() {
		return this.state;
	}

	public Country getCountry() {
		return this.country;
	}

}
