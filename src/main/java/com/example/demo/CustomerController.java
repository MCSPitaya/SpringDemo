package com.example.demo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customers")
@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repo;

	@RequestMapping
	public Iterable<Customer> getAllCustomers(@RequestParam(required = false) String town) {
		Iterable<Customer> data = town != null ? repo.findByTown(town) : repo.findAll();

		for (Customer c : data) {
			c.add(linkTo(CustomerController.class).slash(c.getCustomerId()).withSelfRel());
			c.add(linkTo(CustomerController.class).slash(c.getCustomerId()).slash("/picture")
					.withRel("profilePicture"));
		}

		return data;
	}

	@RequestMapping("{id}")
	public Optional<Customer> getCustomer(@PathVariable Long id) {
		Optional<Customer> customer = repo.findById(id);

		customer.ifPresent(c -> {
			c.add(linkTo(CustomerController.class).withRel("customers"));
			c.add(linkTo(CustomerController.class).slash(c.getCustomerId()).withSelfRel());
			c.add(linkTo(CustomerController.class).slash(c.getCustomerId()).slash("/picture")
					.withRel("profilePicture"));
		});

		return customer;
	}

}
