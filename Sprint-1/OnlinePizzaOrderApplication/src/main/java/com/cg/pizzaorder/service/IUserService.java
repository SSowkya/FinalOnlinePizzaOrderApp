package com.cg.pizzaorder.service;
import com.cg.pizzaorder.exception.NoSuchCustomerException;
import com.cg.pizzaorder.exception.NoSuchPizzaException;
import com.cg.pizzaorder.model.User;

public interface IUserService {
	
	public boolean forgetPassword(String oldPassword,String newPassword);
	public User getLogin(String userName,String userPassword);
	public User viewUser(int userId) throws NoSuchCustomerException ;

	}
