package br.com.casaDoCodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	Optional<Category> findByName(String name);
}
