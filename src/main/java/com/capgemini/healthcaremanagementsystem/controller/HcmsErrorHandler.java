package com.capgemini.healthcaremanagementsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaremanagementsystem.exception.AdminNotFoundException;

@RestController
@ControllerAdvice // used to handle all the exceptions across the application in one global handling component.
public class HcmsErrorHandler {

	/**
	 * Name :handleAdminNotFoundException 
	 * Description:To handle admin with such credentials does not exists
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customer with valid credentials not found")
	@ExceptionHandler(AdminNotFoundException.class)
	public void handleAdminNotFoundException() {
		// TO handle Admin not found
	}
}
