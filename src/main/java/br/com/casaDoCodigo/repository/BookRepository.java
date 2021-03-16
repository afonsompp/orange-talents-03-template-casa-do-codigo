package br.com.casaDoCodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
