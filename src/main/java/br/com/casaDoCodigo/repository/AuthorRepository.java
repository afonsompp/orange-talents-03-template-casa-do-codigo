package br.com.casaDoCodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
