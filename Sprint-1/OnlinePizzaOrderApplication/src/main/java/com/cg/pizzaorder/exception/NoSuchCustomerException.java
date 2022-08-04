package com.cg.pizzaorder.exception;

public class NoSuchCustomerException extends Exception{
	private static final long serialVersionUID = -512056536889030695L;

	public NoSuchCustomerException() {
		super();
		
	}
	public NoSuchCustomerException(String message) {
		super(message);
	}
	public NoSuchCustomerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public NoSuchCustomerException(String message, Throwable cause) {
		super(message, cause);
	}
	public NoSuchCustomerException(Throwable cause) {
		super(cause);
	}	
	
}

