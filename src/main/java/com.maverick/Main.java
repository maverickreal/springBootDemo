package com.maverick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@SpringBootApplication @RestController @RequestMapping("/api/v1/customers")
public class Main{
	private final CustomerRepository repo;
	public Main(CustomerRepository Repo){
		repo=Repo;
	}
	public static void main(String args[]){
		SpringApplication.run(Main.class, args);
	}
	@GetMapping
	public List<Customer> getCustomers(){
		return repo.findAll();
	}
}