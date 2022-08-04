package com.cg.pizzaorder.service;

import java.time.LocalDate;
import java.util.List;
import com.cg.pizzaorder.exception.NoSuchPizzaOrderException;
import com.cg.pizzaorder.exception.PizzaOrderAlreadyExists;
import com.cg.pizzaorder.model.PizzaOrder;

public interface IPizzaOrderService {
	public PizzaOrder bookPizzaOrder(PizzaOrder order) throws PizzaOrderAlreadyExists;
	public PizzaOrder updatePizzaOrder(PizzaOrder order) throws NoSuchPizzaOrderException;
	public PizzaOrder cancelPizzaOrder(int bookingOrderId) throws NoSuchPizzaOrderException;
	public PizzaOrder viewPizzaOrder(int bookingOrderId) throws NoSuchPizzaOrderException;
	public List<PizzaOrder> viewOrdersList();
	public List<PizzaOrder> viewOrdersList(LocalDate date);
	public List<PizzaOrder> calculateTotal(String size,int quantity);
	public double totalCost(int pizzaId);
}
