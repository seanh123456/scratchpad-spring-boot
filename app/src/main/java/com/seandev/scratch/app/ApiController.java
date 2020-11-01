package com.seandev.scratch.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:8080" })
public class ApiController {

	@Autowired
	private CustomerRepository repository;

	@GetMapping("/")
	public Map<String, String> homepage() {
		Map<String, String> message = new HashMap<>();
		Customer customer = repository.findByFirstName("Alice");
		message.put("message", String.format("Hello %s %s from Spring Boot World!", customer.firstName, customer.lastName));
		System.out.println("hey: " + customer.toString());
		return message;
	}
	
	@GetMapping("/counter/increment")
	public Customer increment(String id) {
		Optional<Customer> customer = repository.findById(id);
		if (customer.isPresent()) {
			Customer rval = customer.get();
			rval.increment();
			repository.save(rval);
			return rval;
		}
		return null;
	}
	
	@GetMapping("/counter/decrement")
	public Customer decrement(String id) {
		Optional<Customer> customer = repository.findById(id);
		if (customer.isPresent()) {
			Customer rval = customer.get();
			rval.decrement();
			repository.save(rval);
			return rval;
		}
		return null;
	}
}
