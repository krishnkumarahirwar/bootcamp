package com.capgemini.healthcaremanagementsystem.service;

import java.util.List;

import com.capgemini.healthcaremanagementsystem.entity.Customer;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;

public interface CustomerService {
	
	Customer registerCustomer(Customer customer);

	//Customer getCustomer(Long customerId);



//	Customer updateCustomerpassword(String customerId, String customerPassword);
	
	Test findTestById(Long testId) throws TestNotFoundException;
	
	List<Test> findAllTests();

	Customer customerLogin(String customerName, String customerPassword);
	
}
