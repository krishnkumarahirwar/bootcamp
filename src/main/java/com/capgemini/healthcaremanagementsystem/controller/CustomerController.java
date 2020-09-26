package com.capgemini.healthcaremanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaremanagementsystem.entity.Customer;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;
import com.capgemini.healthcaremanagementsystem.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public Customer registerCustomer(@RequestBody Customer customer){
		return customerService.registerCustomer(customer);
	}
	
	@PostMapping("/login")
	public Customer customerLogin(@RequestBody Customer customer) {
		String customerName= customer.getCustomerName();
		String customerPassword=customer.getCustomerPassword();
		return customerService.customerLogin(customerName,customerPassword);
	}
		
	
	@GetMapping("/findAllTest")
	public ResponseEntity<List<Test>> findAllTest() {
		System.out.println("ritu");
		List<Test> testlist =customerService.findAllTests();
		ResponseEntity<List<Test>> response = new ResponseEntity<>(testlist, HttpStatus.OK);
		return response;
	}

	@GetMapping("/findTest/{id}")
	public ResponseEntity<Test> findTest(@PathVariable("id") Long testId) throws TestNotFoundException {
		Test test = customerService.findTestById(testId);
		ResponseEntity<Test> response = new ResponseEntity<>(test, HttpStatus.OK);
		return response;
	}

}
