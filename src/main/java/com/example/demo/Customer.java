package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class Customer extends ResourceSupport {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String town;

	protected Customer() {
		// JPA
	};

	public Customer(String firstName, String lastName, String town) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.town = town;
	}

	@Override
	public String toString() {
		return String.format("Customer[id%d, firstName='%s', lastName='%s', town='%s']", id, firstName, lastName, town);
	}

	public Long getCustomerId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

}
