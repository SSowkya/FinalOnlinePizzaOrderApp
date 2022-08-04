package com.cg.pizzaorder.service;

import java.util.List;

import com.cg.pizzaorder.exception.CustomerAlreadyExists;
import com.cg.pizzaorder.exception.NoSuchCustomerException;
import com.cg.pizzaorder.model.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(Customer c)throws CustomerAlreadyExists;
	public List<Customer> viewCustomer();
	public Customer deleteCustomer(long customerId) throws NoSuchCustomerException;
	public Customer viewCustomer(long customerId) throws NoSuchCustomerException;
	public Customer updateCustomer(Customer c) throws NoSuchCustomerException;
	

}
