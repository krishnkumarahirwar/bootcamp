package com.capgemini.healthcaremanagementsystem.exception;

public class EmailAlreadyExistException extends RuntimeException {

	public EmailAlreadyExistException(String message) {
		super(message);
	}
}
