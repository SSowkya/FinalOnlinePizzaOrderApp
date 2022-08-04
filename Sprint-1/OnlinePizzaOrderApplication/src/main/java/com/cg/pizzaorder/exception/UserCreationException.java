package com.cg.pizzaorder.exception;

public class UserCreationException extends Exception {
	public UserCreationException()
	{
		super();
	}
	public UserCreationException(String errorMsg)
	{
		super(errorMsg);
	}
	public UserCreationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public UserCreationException(String message, Throwable cause) {
		super(message, cause);
	}
	public UserCreationException(Throwable cause) {
		super(cause);
	}
	
}

