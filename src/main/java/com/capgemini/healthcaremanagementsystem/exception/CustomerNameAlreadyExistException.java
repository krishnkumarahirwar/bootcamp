package com.capgemini.healthcaremanagementsystem.exception;

public class CustomerNameAlreadyExistException extends RuntimeException {

	public CustomerNameAlreadyExistException(String message) {
		super(message);
	}

	public CustomerNameAlreadyExistException() {
		super();
	}
}