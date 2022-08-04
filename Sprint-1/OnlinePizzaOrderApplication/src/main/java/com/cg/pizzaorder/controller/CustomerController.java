package com.cg.pizzaorder.controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pizzaorder.dao.AdminDao;
import com.cg.pizzaorder.dao.CustomerDao;
import com.cg.pizzaorder.exception.CustomerAlreadyExists;
import com.cg.pizzaorder.exception.NoSuchCustomerException;
import com.cg.pizzaorder.model.Admin;
import com.cg.pizzaorder.model.Customer;

@RestController
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	CustomerDao dao;

	@Autowired
	AdminDao admindao;

	Logger 
	logger=org.slf4j.LoggerFactory.getLogger(CustomerController.class);
	
	// for customer registration.
	@RequestMapping(value = "/CreateCustomer", method = RequestMethod.POST)
	@ResponseBody
	public Customer addCustomer(@RequestBody Customer customer)
			throws CustomerAlreadyExists {
		Customer b = dao.addCustomer(customer);
		if (b != null) {

			//System.out.println("Customer is created");
			logger.info("Customer is Created");
			
		} else {
		//	System.out.println("not able to create book object");
			logger.error("Unable to Create the Customer data,Already the Customer Exists");

		}
		return b;

	}

	// for retrieving the customer details.
	@GetMapping(path = "/customer")
	public List<Customer> getCustomers() 
	{
		logger.info("Fetched the Customer details");
	return dao.viewCustomer();

	}

	// for retrieving the customer details based on id.
	@GetMapping(path = "/Customer/{id}")
	public Customer viewCustomerById(@PathVariable long id) throws NoSuchCustomerException {
		logger.info("Fetched the Customer details based on id");

		return dao.viewCustomer(id);
	}

	// for deleting the already posted customer.
	@DeleteMapping(path = "DeleteCustomer/{id}")
	public Customer deleteCustomer(@PathVariable long id) throws NoSuchCustomerException {
		logger.info("Deleted the Customer details based on id");

		return dao.deleteCustomer(id);
	}

	// for updating the customer details.
	@PutMapping(path = "Update/customer/{customerId}")
	public Customer updateCustomer(@RequestBody @Valid Customer customer,@PathVariable long customerId) throws NoSuchCustomerException {
		logger.info("Updated the Customer details");

		return this.dao.updateCustomer(customer);
	}
	
}
