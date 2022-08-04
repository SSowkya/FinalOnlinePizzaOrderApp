package com.cg.pizzaorder.service;

import java.util.List;

import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.cg.pizzaorder.exception.InvalidLoginException;
import com.cg.pizzaorder.model.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin);
	public int deleteAdmin(int adminId);
	public String getAdminName(int adminId);
	public String getAdminPassword(int adminId);
	public List<Admin> viewAdmins();
	public Admin getLogin(String userName,String userPassword) throws InvalidLoginException;

}
