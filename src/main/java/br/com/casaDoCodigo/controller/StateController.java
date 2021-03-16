package br.com.casaDoCodigo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casaDoCodigo.controller.dto.StateDto;
import br.com.casaDoCodigo.controller.dto.StateResponseDto;
import br.com.casaDoCodigo.repository.CountryRepository;
import br.com.casaDoCodigo.repository.StateRepository;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/states")
public class StateController {
	private final StateRepository stateRepository;
	private final CountryRepository countryRepository;

	public StateController(StateRepository stateRepository, CountryRepository countryRepository) {
		this.stateRepository = stateRepository;
		this.countryRepository = countryRepository;
	}

	@PostMapping
	public ResponseEntity<StateResponseDto> postMethodName(@RequestBody @Valid StateDto dto) {
		var state = stateRepository.save(dto.parseToState(countryRepository));
		return ResponseEntity.ok(new StateResponseDto(state));
	}

}
