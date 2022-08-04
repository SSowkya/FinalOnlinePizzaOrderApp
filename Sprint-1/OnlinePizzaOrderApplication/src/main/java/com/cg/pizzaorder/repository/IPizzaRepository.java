package com.cg.pizzaorder.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.pizzaorder.model.Pizza;

@Repository
public interface IPizzaRepository extends JpaRepository<Pizza, Integer> {
	
	@Query(value="select *from pizza_table where pizza_type= ?1",nativeQuery = true)
	public List<Pizza> viewPizzaByType(String pizzaType);
	
	@Query(value="	select *from pizza_table where pizza_cost>=?1 and pizza_cost<=?2",nativeQuery = true)
	public List<Pizza> viewPizzaByCost(double minCost, double maxCost);


	
			
	@Query(value="select pizza_name from pizza_table where pizza_name=?1",nativeQuery = true)
	public String viewPizzaByname(String pizzaName);
}
