package com.cg.pizzaorder.dao;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.pizzaorder.exception.CustomerAlreadyExists;
import com.cg.pizzaorder.exception.NoSuchCustomerException;
import com.cg.pizzaorder.model.Customer;
import com.cg.pizzaorder.repository.ICustomerRepository;
import com.cg.pizzaorder.service.ICustomerService;

@Service
public class CustomerDao implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	AdminDao adminDao;

	Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerDao.class);

	public String readInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Admin Details to login");
		System.out.println("Enter Admin Id");
		int adminId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Admin name");
		String adminName = scanner.nextLine();
		System.out.println("Enter Password");
		String password = scanner.nextLine();
		scanner.close();
		return adminId + " " + adminName + " " + password;
	}

	@Override
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExists {

//		String input = readInput();
//		String[] strInput = input.split(" ");
//		int adminId = Integer.parseInt(strInput[0]);
//		String adminName = strInput[1];
//		String password = strInput[2];
//
//		if (adminDao.getAdminName(adminId).equals(adminName) && adminDao.getAdminPassword(adminId).equals(password))
//		{
//			if (customerRepository.existsById(customer.getCustomerId())) {
//				logger.error("Customer had already registered, Sign in ");
//				throw new CustomerAlreadyExists("Customer already exists ");
//			} else {
//				logger.info("Customer added successfully");
//				return customerRepository.save(customer);
//			}
//		}
//		return null;
		Customer c = customerRepository.save(customer);
		return c;
		
	}

	@Override
	public List<Customer> viewCustomer() {
		List<Customer> list = customerRepository.findAll();
		logger.info("Customer Details are Fetched");
		for (Customer c : list)
			logger.info(c.getCustomerId() + " " + c.getCustomerName() + " " + c.getCustomerMobile() + " "
					+ c.getCustomerEmail() + "" + c.getCustomerAddress());
		return list;
	}

		

	@Override
	public Customer updateCustomer(Customer c) throws NoSuchCustomerException {
		Optional<Customer> customer = customerRepository.findById(c.getCustomerId());
		if (customer.isPresent()) {
			customerRepository.save(c);
			logger.info("Customer Details Has Updated");
			return c;
		} else {
			throw new NoSuchCustomerException("No Customer Found,Customer Data couldn't be Updated! ");
		}
	}

	public Customer findbyid(long id) throws NoSuchCustomerException {
		return customerRepository.findById(id)
				.orElseThrow(() -> new NoSuchCustomerException("Customer does not exist"));
	}
	
	@Override
	public Customer viewCustomer(long customerId) throws NoSuchCustomerException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		Customer cust = null;
		if (customer.isPresent()) {
			cust = customer.get();		
		} else {
			throw new NoSuchCustomerException("No such Customer Exists");
		}
		return cust;
	}

	@Override
	public Customer deleteCustomer(long customerId) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		customerRepository.delete(customerRepository.getById(customerId));

		return null;
	}

	
}
