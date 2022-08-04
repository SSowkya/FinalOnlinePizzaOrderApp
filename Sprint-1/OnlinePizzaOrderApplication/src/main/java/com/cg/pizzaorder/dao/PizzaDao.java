package com.cg.pizzaorder.dao;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pizzaorder.exception.NoSuchPizzaException;
import com.cg.pizzaorder.exception.PizzaAlreadyExists;
import com.cg.pizzaorder.model.Pizza;
import com.cg.pizzaorder.repository.IPizzaRepository;
import com.cg.pizzaorder.service.IPizzaService;


@Service
public class PizzaDao implements IPizzaService {
	@Autowired
	IPizzaRepository pizzaRepository;
	@Autowired
	AdminDao adminDao;
	
	Logger 
	logger=org.slf4j.LoggerFactory.getLogger(PizzaDao.class);
	
	public String readInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Admin Details to Login");
		System.out.println("Enter Admin Id");
		int adminId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Admin name");
		String adminName = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		scanner.close();

		return  adminId+ " " + adminName + " " + password ;
	}

	// to add the pizza
	public Pizza addPizza(Pizza pizza) throws PizzaAlreadyExists {

			if(pizzaRepository.existsById(pizza.getPizzaId()))
			{
				logger.error("Pizza already exists exception");
				throw new PizzaAlreadyExists("Pizza already exists");
			}
			else
			{
				logger.info("Pizza added successfully");
				return pizzaRepository.save(pizza);
			}
		
		
	}
	
	//to delete the pizza record
	@Override
	public Pizza deletePizza(int pizzaId) {
		Pizza pizza = pizzaRepository.getById(pizzaId);
		pizzaRepository.delete(pizza);
		
		return null;
	}

	// to view the pizza record using its id
	@Override
	public Pizza viewPizza(int pizzaId) throws NoSuchPizzaException {
		
		Optional<Pizza> found = pizzaRepository.findById(pizzaId);
		if(found.isPresent()) {
			return found.get();
		}else {
			throw new NoSuchPizzaException("This Pizza does not exist");
		}
	}

	//to retrieve the pizza list
	@Override
	public List<Pizza> viewPizzalist(double minCost, double maxCost) {		
		List<Pizza> list=pizzaRepository.viewPizzaByCost(minCost,maxCost);
		return list;
	}

	//to retrieve the pizzalist using its type
	@Override
	public List<Pizza> viewPizzalist(String pizzaType) {
		List<Pizza> list=pizzaRepository.viewPizzaByType(pizzaType);
		return list;	
	}
	
	//to retrieve the pizzalist
	@Override
	public List<Pizza> viewPizzalist() {
		List<Pizza> list = pizzaRepository.findAll();
			for(Pizza c:list)
				logger.info(c.getPizzaId()+ " "+ c.getPizzaName()+" "+c.getPizzaDescription()+" "+c.getPizzaType()+" "+c.getPizzaCost()+""+c.getPizzaCostAfterCoupon());
			return list;			
	}

	public Pizza findbyid(long id) throws NoSuchPizzaException
	{
		return pizzaRepository.findById((int) id).orElseThrow(()-> new NoSuchPizzaException("pizza does not exist"));
	}

	//to update the pizza
	@Override
	public Pizza updatePizza(Pizza pizza) throws NoSuchPizzaException {
		Optional<Pizza> optional = pizzaRepository.findById(pizza.getPizzaId());
		if (optional.isPresent()) {
			pizzaRepository.save(pizza);
			return pizza;
		} else {
			throw new NoSuchPizzaException("Pizza Data couldn't be Updated! ");
		}
	}
	

}
