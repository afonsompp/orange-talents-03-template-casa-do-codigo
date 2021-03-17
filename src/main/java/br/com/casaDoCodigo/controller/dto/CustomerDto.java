package br.com.casaDoCodigo.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.server.ResponseStatusException;

import br.com.casaDoCodigo.Validation.UniqueFieldConstraint;
import br.com.casaDoCodigo.model.Customer;
import br.com.casaDoCodigo.repository.CountryRepository;
import br.com.casaDoCodigo.repository.StateRepository;

public class CustomerDto {

	@NotBlank
	private String name;
	@NotBlank
	private String lastName;
	@NotBlank
	@Email
	@UniqueFieldConstraint(columnName = "email", model = Customer.class)
	private String email;
	@NotBlank
	@Pattern(regexp = "(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)|(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$)")
	private String document;
	@NotBlank
	private String phone;
	@NotBlank
	private String address;
	@NotBlank
	private String complement;
	@NotBlank
	private String city;
	private Long stateId;
	@NotNull
	private Long countryId;

	public CustomerDto() {
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

	public Long getStateId() {
		return this.stateId;
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public Customer parseToCustomer(StateRepository stateRepository, CountryRepository countryRepository)
			throws MethodArgumentNotValidException {
		var country = countryRepository.findById(countryId);
		if (country.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found");
		}

		var state = stateRepository.findByCountryId(countryId);
		if (state.isEmpty()) {
			return new Customer(name, lastName, email, document, phone, address, complement, city, null, country.get());
		}

		if (stateId == null) {
			var binder = new WebDataBinder(stateId);
			var field = new FieldError("stateId", "stateId", "State cannot be null");
			binder.getBindingResult().addError(field);

			throw new MethodArgumentNotValidException(null, binder.getBindingResult());
		}

		state = stateRepository.findById(stateId);
		return new Customer(name, lastName, email, document, phone, address, complement, city, state.get(),
				country.get());

	}

}
