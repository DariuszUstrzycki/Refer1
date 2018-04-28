package pl.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.school.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	// define other query methods by simply declaring their method signature. 
    List<Customer> findByLastName(String lastName);
}