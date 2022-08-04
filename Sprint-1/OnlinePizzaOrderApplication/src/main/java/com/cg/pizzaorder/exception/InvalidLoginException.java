package com.cg.pizzaorder.exception;

public class InvalidLoginException extends RuntimeException {
	
	
	public InvalidLoginException(String error)
	{
		super(error);
	}
}
