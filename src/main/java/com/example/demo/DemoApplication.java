package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(CustomerRepository repo) {
		return args -> {
			repo.save(new Customer("Dillon", "Galloway", "Bern"));
			repo.save(new Customer("Ireland", "Foley", "Zürich"));
			repo.save(new Customer("Kaylynn", "Archer", "Geneva"));
			repo.save(new Customer("Marilyn", "Hatfield", "Bern"));
			repo.save(new Customer("Jaqueline", "Morgan", "Luzern"));
			repo.save(new Customer("Braydon", "Ho", "Zürich"));
			repo.save(new Customer("Alessandro", "Hendricks", "Luzern"));
		};
	}
	
}
