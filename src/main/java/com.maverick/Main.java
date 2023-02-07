package com.maverick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	static private final record newCustomer(String name, String email, int age){}

	@PostMapping
	public void addCustomer(@RequestBody newCustomer req){
		Customer cust = new Customer();
		cust.setName(req.name());
		cust.setAge(req.age());
		cust.setEmail(req.email());
		repo.save(cust);
	}

	@DeleteMapping("{Id}")
	public void deleteCustomer(@PathVariable("Id") int id){
		repo.deleteById(id);
	}

	@PutMapping("{Id}")
	public void updateCustomer(@RequestBody newCustomer req, @PathVariable("Id") int id){
		Customer cust = repo.findById(id).get();
		cust.setName(req.name());
		cust.setAge(req.age());
		cust.setEmail(req.email());
		repo.save(cust);
	}
}