package com.cg.pizzaorder.service;


import java.util.List;

import com.cg.pizzaorder.exception.NoSuchPizzaException;
import com.cg.pizzaorder.exception.PizzaAlreadyExists;
import com.cg.pizzaorder.model.Pizza;

public interface IPizzaService {

	public Pizza addPizza(Pizza pizza)throws PizzaAlreadyExists;;
	public Pizza updatePizza(Pizza pizza) throws NoSuchPizzaException;
	public Pizza deletePizza(int pizzaId) throws NoSuchPizzaException;
	public List<Pizza> viewPizzalist();
	public Pizza viewPizza(int pizzaId) throws NoSuchPizzaException;
	public List<Pizza> viewPizzalist(double minCost , double maxCost);
	public List<Pizza> viewPizzalist(String pizzaType);
	

}
