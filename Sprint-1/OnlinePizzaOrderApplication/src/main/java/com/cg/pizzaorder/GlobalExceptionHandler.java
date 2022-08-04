package com.cg.pizzaorder;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cg.pizzaorder.exception.CouponAlreadyExists;
import com.cg.pizzaorder.exception.CustomerAlreadyExists;
import com.cg.pizzaorder.exception.ErrorMessage;
import com.cg.pizzaorder.exception.NoSuchCouponException;
import com.cg.pizzaorder.exception.NoSuchCustomerException;
import com.cg.pizzaorder.exception.NoSuchPizzaException;
import com.cg.pizzaorder.exception.NoSuchPizzaOrderException;
import com.cg.pizzaorder.exception.PizzaAlreadyExists;
import com.cg.pizzaorder.exception.PizzaOrderAlreadyExists;
import com.cg.pizzaorder.exception.UserCreationException;


@ControllerAdvice

public class GlobalExceptionHandler {
	@ExceptionHandler(CustomerAlreadyExists.class)
	public @ResponseBody ErrorMessage checkCustomerAlreadyExistsException(CustomerAlreadyExists e,HttpServletRequest request)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), request.getRequestURI(), e.getMessage());
		return error1;
	}
	
	@ExceptionHandler(NoSuchCustomerException.class)
	public @ResponseBody ErrorMessage checkNoSuchCustomerException(NoSuchCustomerException e,HttpServletRequest request)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), request.getRequestURI(), e.getMessage());
		return error1;
	}
	
	@ExceptionHandler(PizzaAlreadyExists.class)
	public @ResponseBody ErrorMessage checkPizzaAlreadyExistsxception(PizzaAlreadyExists e,HttpServletRequest request)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), request.getRequestURI(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(NoSuchPizzaException.class)
	public @ResponseBody ErrorMessage checkNoSuchPizzaException(NoSuchPizzaException e,HttpServletRequest request)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), request.getRequestURI(), e.getMessage());
		return error1;
	}
	

	@ExceptionHandler(CouponAlreadyExists.class)
	public @ResponseBody ErrorMessage checkCouponAlreadyExistsxception(CouponAlreadyExists e,HttpServletRequest request)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), request.getRequestURI(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(NoSuchCouponException.class)
	public @ResponseBody ErrorMessage checkNoSuchCouponException(NoSuchCouponException e,HttpServletRequest request)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), request.getRequestURI(), e.getMessage());
		return error1;
	}
	
	@ExceptionHandler(PizzaOrderAlreadyExists.class)
	public @ResponseBody ErrorMessage checkPizzaOrderAlreadyExistsException(PizzaOrderAlreadyExists e,HttpServletRequest request)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), request.getRequestURI(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(NoSuchPizzaOrderException.class)
	public @ResponseBody ErrorMessage checkNoSuchPizzaOrderException(NoSuchPizzaOrderException e,HttpServletRequest request)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), request.getRequestURI(), e.getMessage());
		return error1;
	}
	
	@ExceptionHandler(UserCreationException.class)
	public @ResponseBody ErrorMessage checkUserCreationException(UserCreationException e,HttpServletRequest request)
	
	{
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), request.getRequestURI(), e.getMessage());
		return error1;
	}
	
		
}
