package com.cg.pizzaorder.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.pizzaorder.model.Admin;
import com.cg.pizzaorder.model.User;

@Repository
public interface IUserRepository  extends JpaRepository<User, Integer> {


	@Query(value= " select user_name from user_table where user_id=?1", nativeQuery=true)
	public String getUserName(int userId);
	@Query(value=" select user_password from user_table where user_id=?1", nativeQuery=true)
	public String getUserPassword(int userId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE user_table SET  user_password = ?1	WHERE user_password=?2",nativeQuery=true)
	public int UpdatePassword(String newPassword,String oldPassword);
	
	
	@Query(value="select a from User a where a.userName=?1 and a.userPassword=?2")
	public User getLogin(String userName,String userPassword);
	

	
	
	
	

}
