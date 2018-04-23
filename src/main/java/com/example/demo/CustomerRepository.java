package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

	// SELECT * FROM customers WHERE town='?'
	List<Customer> findByTown(String town);
	
}
