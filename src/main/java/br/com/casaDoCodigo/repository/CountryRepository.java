package br.com.casaDoCodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
