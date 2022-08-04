package com.cg.pizzaorder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;





@Entity
@Table(name="Pizza_Table")
public class Pizza {
	@Id	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
private int pizzaId;
	@NotBlank(message="Pizza Name Should not be null")
private String pizzaName;
private String pizzaType;
private String pizzaDescription;
private double pizzaCost;
private double pizzaCostAfterCoupon;


public int getPizzaId() {
	return pizzaId;
}
public void setPizzaId(int pizzaId) {
	this.pizzaId = pizzaId;
}
public String getPizzaName() {
	return pizzaName;
}
public void setPizzaName(String pizzaName) {
	this.pizzaName = pizzaName;
}
public String getPizzaType() {
	return pizzaType;
}
public void setPizzaType(String pizzaType) {
	this.pizzaType = pizzaType;
}
public String getPizzaDescription() {
	return pizzaDescription;
}
public void setPizzaDescription(String pizzaDescription) {
	this.pizzaDescription = pizzaDescription;
}
public double getPizzaCost() {
	return pizzaCost;
}
public void setPizzaCost(double pizzaCost) {
	this.pizzaCost = pizzaCost;
}
public double getPizzaCostAfterCoupon() {
	return pizzaCostAfterCoupon;
}
public void setPizzaCostAfterCoupon(double pizzaCostAfterCoupon) {
	this.pizzaCostAfterCoupon = pizzaCostAfterCoupon;
}

}
