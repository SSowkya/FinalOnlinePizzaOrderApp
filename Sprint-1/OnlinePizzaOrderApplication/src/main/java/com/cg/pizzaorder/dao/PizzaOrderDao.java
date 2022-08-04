package com.cg.pizzaorder.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.pizzaorder.exception.NoSuchPizzaOrderException;
import com.cg.pizzaorder.exception.PizzaOrderAlreadyExists;
import com.cg.pizzaorder.model.PizzaOrder;
import com.cg.pizzaorder.repository.IPizzaOrderRepository;
import com.cg.pizzaorder.repository.IUserRepository;
import com.cg.pizzaorder.service.IPizzaOrderService;

@Service
public class PizzaOrderDao implements IPizzaOrderService {
	@Autowired
	IPizzaOrderRepository pizzaorderRepository;

	@Autowired
	IUserRepository userRepository;
	Logger logger = org.slf4j.LoggerFactory.getLogger(PizzaOrderDao.class);

	public boolean login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter User Details to Login");
		System.out.println("Enter User Id");
		int userId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter User name");
		String userName = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		scanner.close();
		if (userRepository.getUserName(userId).equals(userName)
				&& userRepository.getUserPassword(userId).equals(password))

		{
			logger.info("Login Succesfully");
			return true;
		}
		logger.warn("Invalid Login,User Not Found");
		return false;

	}

	// to order the pizza
	@Override
	public PizzaOrder bookPizzaOrder(PizzaOrder pizza) throws PizzaOrderAlreadyExists {

		if (pizzaorderRepository.existsById(pizza.getBookingOrderId())) {
			logger.error("PizzaOrder already exists exception");
			throw new PizzaOrderAlreadyExists("PizzaOrder already exists");
		} else {
			logger.info("PizzaOrder added successfully");
			return pizzaorderRepository.save(pizza);
		}

	}

	// to update the pizza
	@Override
	public PizzaOrder updatePizzaOrder(PizzaOrder order) throws NoSuchPizzaOrderException {
		Optional<PizzaOrder> optional = pizzaorderRepository.findById(order.getBookingOrderId());
		if (optional.isPresent()) {
			pizzaorderRepository.save(order);
			return order;
		} else {
			throw new NoSuchPizzaOrderException("PizzaOrder Data couldn't be Updated! ");
		}
	}

	// to cancel the order
	@Override
	public PizzaOrder cancelPizzaOrder(int bookingOrderId) {
		PizzaOrder order = pizzaorderRepository.getById(bookingOrderId);
		pizzaorderRepository.delete(order);
		return null;

	}

//to retrieve the order id
	@Override
	public PizzaOrder viewPizzaOrder(int bookingOrderId) throws NoSuchPizzaOrderException {
		Optional<PizzaOrder> found = pizzaorderRepository.findById(bookingOrderId);
		if (found.isPresent()) {
			return found.get();
		} else {
			throw new NoSuchPizzaOrderException("This Pizza does not exist");
		}
	}

	// to retrieve the order list
	@Override
	public List<PizzaOrder> viewOrdersList() {
		List<PizzaOrder> list = pizzaorderRepository.findAll();
		for (PizzaOrder c : list)
			logger.info(c.getBookingOrderId() + " " + c.getSize() + " " + c.getQuantity() + " " + c.getOrderDate() + " "
					+ c.getPizza() + "" + c.getCoupon() + "" + c.getPizza() + "" + c.getTransactionMode());
		return list;
	}

	// to retrieve the order list using date

	@Override
	public List<PizzaOrder> viewOrdersList(LocalDate date) {
		List<PizzaOrder> list = pizzaorderRepository.viewPizzaOrderByDate(date);
		return list;
	}

	@Override
	public List<PizzaOrder> calculateTotal(String size, int quantity) {
		List<PizzaOrder> list = pizzaorderRepository.viewPizzaOrderByCost(size, quantity);
		return list;
	}

	// to retrieve the total cost using size and quantity

	@Override
	public double totalCost(int pizzaId) {
		// TODO Auto-generated method stub
		return pizzaorderRepository.TotalCost(pizzaId);
	}

}
