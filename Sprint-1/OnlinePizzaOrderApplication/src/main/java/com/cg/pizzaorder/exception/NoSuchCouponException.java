package com.cg.pizzaorder.exception;

public class NoSuchCouponException extends Exception {
	public NoSuchCouponException(String errorMsg)
	{
		super(errorMsg);
	}
}
