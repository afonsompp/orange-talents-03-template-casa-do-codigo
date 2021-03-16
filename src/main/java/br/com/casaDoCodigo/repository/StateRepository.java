package br.com.casaDoCodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.model.State;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {

}
