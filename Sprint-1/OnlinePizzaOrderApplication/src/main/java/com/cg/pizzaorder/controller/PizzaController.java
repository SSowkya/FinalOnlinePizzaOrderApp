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
import org.springframework.web.bind.annotation.RestController;
import com.cg.pizzaorder.dao.PizzaDao;
import com.cg.pizzaorder.exception.NoSuchPizzaException;
import com.cg.pizzaorder.exception.PizzaAlreadyExists;
import com.cg.pizzaorder.model.Pizza;

@RestController
@CrossOrigin("*")
public class PizzaController {
	@Autowired
	PizzaDao pizzadao;
	
	Logger 
	logger=org.slf4j.LoggerFactory.getLogger(PizzaController.class);
	
	// for pizza registration.
	@PostMapping(path = "/CreatePizza")
	public Pizza addPizza(@Valid@RequestBody Pizza pizza) throws PizzaAlreadyExists {
		Pizza p = pizzadao.addPizza(pizza);
		if (p != null) {
			//System.out.println("Pizza is created");
			logger.info("Pizza is Created");
		} else {
			//System.out.println("not able to create Pizza");
			logger.error("Unable to Create the Pizza Data,Pizza Already Exists");
		}
		return p;

	}

	// for retrieving the pizza details.
	@GetMapping(path = "/pizza")
	public List<Pizza> getPizzas() {
		logger.info("Fetched The Pizza Details");
		return pizzadao.viewPizzalist();
	}

	// for retrieving the pizza details based on id.
	@GetMapping(path = "/Pizza/{id}")
	public Pizza viewPizzaById(@PathVariable int id) throws NoSuchPizzaException {
		if(id==0)
		{		
		logger.info("Cant Fetch The Pizza Details");
		}
		logger.info("Fetched The Pizza Details Based On Id");
		return pizzadao.viewPizza(id);

	}

	// for retrieving the pizza details based on type.
	@RequestMapping(value = "/Pizza/pizzaType/{pizzaType}", method = RequestMethod.GET)
	public List<Pizza> viewPizzaByType(@PathVariable String pizzaType) throws NoSuchPizzaException {
		logger.info("Fetched The Pizza Details based on pizzaType");
		return pizzadao.viewPizzalist(pizzaType);
	}

	// for retrieving the pizza details based on cost.
	@RequestMapping(value = "/Pizza/pizzaCost/{minCost}/{maxCost}", method = RequestMethod.GET)
	public List<Pizza> viewPizzaByCost(@PathVariable double minCost, @PathVariable double maxCost)
			throws NoSuchPizzaException {
		logger.info("Fetched The Pizza Details based on Cost");

		return pizzadao.viewPizzalist(minCost, maxCost);
	}

	// for deleting the pizza.
	@DeleteMapping(path = "DeletePizza/{id}")
	public Pizza deletePizza(@PathVariable int id) throws NoSuchPizzaException {
		logger.info("Deleted The Pizza Details based on id");
		return pizzadao.deletePizza(id);
	}

	// for updating the pizza details.
	@PutMapping(path = "Update/pizza/{id}")
	public Pizza updateStatus(@RequestBody @Valid Pizza pizza,@PathVariable int id) throws NoSuchPizzaException {
		logger.info("Updated The Pizza Details based on Cost");
		return this.pizzadao.updatePizza(pizza);
	}
}
