package br.com.casaDoCodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.model.State;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {

	@Query("SELECT s FROM State s WHERE country.id = :countryId")
	Optional<State> findByCountryId(@Param("countryId") Long countryId);
}
