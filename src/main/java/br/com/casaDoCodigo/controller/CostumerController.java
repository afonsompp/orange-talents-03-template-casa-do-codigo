package br.com.casaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casaDoCodigo.controller.dto.CustomerDto;
import br.com.casaDoCodigo.controller.dto.CustomerResponseDto;
import br.com.casaDoCodigo.repository.CountryRepository;
import br.com.casaDoCodigo.repository.CustomerRepository;
import br.com.casaDoCodigo.repository.StateRepository;

@RestController
@RequestMapping("/customers")
public class CostumerController {
	private final CustomerRepository customerRepository;
	private final StateRepository stateRepository;
	private final CountryRepository countryRepository;

	public CostumerController(CustomerRepository customerRepository, StateRepository stateRepository,
			CountryRepository countryRepository) {
		this.customerRepository = customerRepository;
		this.stateRepository = stateRepository;
		this.countryRepository = countryRepository;
	}

	@PostMapping
	public ResponseEntity<CustomerResponseDto> postMethodName(@RequestBody @Valid CustomerDto dto)
			throws MethodArgumentNotValidException {
		var customer = customerRepository.save(dto.parseToCustomer(stateRepository, countryRepository));

		return ResponseEntity.ok(new CustomerResponseDto(customer));
	}

}
