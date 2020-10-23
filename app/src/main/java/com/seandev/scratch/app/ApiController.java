package com.seandev.scratch.app;

import java.util.HashMap;
import java.util.Map;

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
}
