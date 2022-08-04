package com.cg.pizzaorder.controller;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.pizzaorder.dao.AdminDao;
import com.cg.pizzaorder.dao.UserDao;
import com.cg.pizzaorder.exception.InvalidLoginException;
import com.cg.pizzaorder.exception.NoSuchCustomerException;

import com.cg.pizzaorder.model.User;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	UserDao userdao;
		@Autowired
		AdminDao admindao;
		Logger 
		logger=org.slf4j.LoggerFactory.getLogger(UserDao.class);
		

	
		
		@PutMapping(path = "Update/{oldPassword}/{newPassword}")

		public boolean forgetPassword(@PathVariable String oldPassword, @PathVariable String newPassword) {
			
			return userdao.forgetPassword(oldPassword, newPassword);
			
			
		}
		@GetMapping(path = "user/login/{userName}/{userPassword}")
		public User getUserLogin(@PathVariable String userName, @PathVariable String userPassword) {
			return userdao.getLogin(userName, userPassword);

		}
		@GetMapping(path = "/User/{id}")
		public User extractUserbyId(@PathVariable int id) throws NoSuchCustomerException {
			if(id==0)
			{		
			logger.info("Cant Fetch The User Details");
			}
			logger.info("Fetched The User Details Based On Id");
			return userdao.viewUser(id);

		}

}
