package com.cg.pizzaorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.pizzaorder.model.Admin;


@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
/*
 * save(Entity object)
 * {
 *
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 */
	

	@Query(value= "select admin_name from admin_table where admin_id=?1", nativeQuery=true)
	public String getAdminName(int adminId);
	@Query(value="select admin_password from admin_table where admin_id=?1", nativeQuery=true)
	public String getAdminPassword(int adminId);

	@Query(value="select a from Admin a where a.adminName=?1 and a.adminPassword=?2")
	public Admin getLogin(String userName,String userPassword);
	
	
}

