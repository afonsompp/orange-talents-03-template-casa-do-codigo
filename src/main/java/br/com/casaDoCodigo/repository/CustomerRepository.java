package br.com.casaDoCodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
