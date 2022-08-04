package com.cg.pizzaorder.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.pizzaorder.dao.PizzaOrderDao;
import com.cg.pizzaorder.exception.NoSuchPizzaException;
import com.cg.pizzaorder.exception.NoSuchPizzaOrderException;
import com.cg.pizzaorder.exception.PizzaOrderAlreadyExists;
import com.cg.pizzaorder.model.PizzaOrder;

@RestController
@CrossOrigin("*")
public class PizzaOrderController {
	@Autowired
	PizzaOrderDao pizzaOrderDao;
	
	Logger 
	logger=org.slf4j.LoggerFactory.getLogger(PizzaOrderController.class);
	
	//for booking pizza.
	@PostMapping(path = "bookPizza")
	public PizzaOrder bookPizza(@Valid@RequestBody PizzaOrder pizza) throws  PizzaOrderAlreadyExists
	{
		PizzaOrder p = pizzaOrderDao.bookPizzaOrder(pizza);
		if (p != null) {
			
			//System.out.println("PizzaOrder is created");
			logger.info("PizzaOrder is Created");
		}
		else
		{
			//System.out.println("not able to create PizzaOrder object");
			logger.error("Unable to Create PizzaOrder");

		}
		return p;
		
	}
	
	//for retrieving the order details
	@GetMapping(path = "/pizzaOrder")
	public List<PizzaOrder> getOrders()
	{	
		logger.info("Fetched Order Details");

		return pizzaOrderDao.viewOrdersList(); 	
	}
	
	//for retrieving the order details based on id
	@GetMapping(path="/pizzaOrder/{id}")
	public PizzaOrder viewPizzaOrderById(@PathVariable int id) throws NoSuchPizzaOrderException{
		logger.info("Fetched the PizzaOrder by Id");

		return pizzaOrderDao.viewPizzaOrder(id);
	}
	
	//for retrieving the order details based on size and quantity.
	@RequestMapping(value = "/pizzaOrder/pizzaOrderCaculate/{size}/{quantity}", method = RequestMethod.GET)
	public List<PizzaOrder> viewPizzaOrderByCost(@PathVariable String size,@PathVariable int quantity) throws NoSuchPizzaException{
		logger.info("Fetched the PizzaOrder by Size and Quantity");

		return pizzaOrderDao.calculateTotal(size,quantity);
	}
	
	//for retrieving the order details based on date.
	@PostMapping("/pizzaOrder/pizzaOrderDate/{date}")
	public List<PizzaOrder> viewPizzaOrderByDate(@RequestParam("date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws NoSuchPizzaException{
		logger.info("Fetched the PizzaOrder by Date");

		return pizzaOrderDao.viewOrdersList(date);
	}
	
	//for updating the order details.
	@PutMapping(path="Update/pizzaOrder/{bookingOrderid}")
	public PizzaOrder updateStatus(@RequestBody @Valid PizzaOrder order,@PathVariable int bookingOrderid) throws NoSuchPizzaOrderException {
		logger.info("Updated the PizzaOrder by Id");
	
			return this.pizzaOrderDao.updatePizzaOrder(order);		
		}
	
	//for deleting the order details.
	@DeleteMapping(path="pizzaOrder/{bookingOrderid}")
	public PizzaOrder deletePizza(@PathVariable int bookingOrderid) throws NoSuchPizzaOrderException {
		logger.info("Delted the PizzaOrder by Id");

		return pizzaOrderDao.cancelPizzaOrder(bookingOrderid);
	}
	@GetMapping(path="pizzaOrder/TotalCost/{pizzaId}")
	public double calculateTotaCost(@PathVariable int pizzaId) {
		//logger.info("Fetched the PizzaOrder by Id");

		return pizzaOrderDao.totalCost(pizzaId);
	}
}
