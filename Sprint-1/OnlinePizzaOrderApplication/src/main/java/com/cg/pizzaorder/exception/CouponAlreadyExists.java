package com.cg.pizzaorder.exception;

public class CouponAlreadyExists extends Exception {

	private static final long serialVersionUID = -4910357217437995576L;

	public CouponAlreadyExists(String str)
	{
		super(str);
	}
}