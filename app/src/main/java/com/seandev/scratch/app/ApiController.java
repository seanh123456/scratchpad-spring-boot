package com.seandev.scratch.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/api")
	public Map<String, String> homepage() {
		Map<String, String> message = new HashMap<>();
		Customer customer = repository.findByFirstName("Alice");
		message.put("message", String.format("Hello %s %s from Spring Boot World!", customer.firstName, customer.lastName));
		return message;
	}
	
	@GetMapping("/api/counter/increment")
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
	
	@GetMapping("/api/counter/decrement")
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
