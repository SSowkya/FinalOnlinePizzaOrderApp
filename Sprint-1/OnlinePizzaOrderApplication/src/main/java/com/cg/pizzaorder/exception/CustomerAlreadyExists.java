package com.cg.pizzaorder.exception;

@SuppressWarnings("serial")
public class CustomerAlreadyExists extends Exception {
	public CustomerAlreadyExists(String str)
	{
		super(str);
	}
}
