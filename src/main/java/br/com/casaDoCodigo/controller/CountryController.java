package br.com.casaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casaDoCodigo.controller.dto.CountryDto;
import br.com.casaDoCodigo.controller.dto.CountryResponseDto;
import br.com.casaDoCodigo.repository.CountryRepository;

@RestController
@RequestMapping("/countries")
public class CountryController {

	private CountryRepository countryRepository;

	public CountryController(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PostMapping
	public ResponseEntity<CountryResponseDto> save(@RequestBody @Valid CountryDto dto) {
		var country = countryRepository.save(dto.parseToCountry());

		return ResponseEntity.ok(new CountryResponseDto(country));
	}

}
