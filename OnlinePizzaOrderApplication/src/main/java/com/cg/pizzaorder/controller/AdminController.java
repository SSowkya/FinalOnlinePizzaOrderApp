package com.cg.pizzaorder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.pizzaorder.dao.AdminDao;
import com.cg.pizzaorder.model.Admin;

@RestController
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private AdminDao adminDao;

	// for admin registration.
	@PostMapping(path = "/CreateAdmin")
	public Admin createAdmin(@Valid @RequestBody Admin admin) {
		return adminDao.addAdmin(admin);
	}

	// for deleting the already posted admin.
	@DeleteMapping(path = "DeleteAdmin/{id}")
	public int deleteAdmin(@PathVariable int id) {
		return adminDao.deleteAdmin(id);
	}

	// for retrieving the admin details.
	@GetMapping(path = "/admin")
	public List<Admin> getAdmin() {

		return adminDao.viewAdmins();

	}

	@GetMapping(path = "admin/login/{adminName}/{adminPassword}")
	public Admin getUserLogin(@PathVariable String adminName, @PathVariable String adminPassword) {
		return adminDao.getLogin(adminName, adminPassword);

	}

}