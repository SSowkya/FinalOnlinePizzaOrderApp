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
import org.springframework.web.bind.annotation.RestController;

import com.cg.pizzaorder.dao.CouponDao;
import com.cg.pizzaorder.exception.CouponAlreadyExists;
import com.cg.pizzaorder.exception.NoSuchCouponException;
import com.cg.pizzaorder.exception.NoSuchPizzaException;
import com.cg.pizzaorder.model.Coupon;
import com.cg.pizzaorder.model.Pizza;

@RestController
@CrossOrigin("*")

public class CouponController {

	@Autowired
	CouponDao couponDao;

	Logger 
	logger=org.slf4j.LoggerFactory.getLogger(CouponController.class);
	
	//for coupon registration.
	@PostMapping(path = "/CreateCoupon")
	public Coupon addCoupon(@Valid @RequestBody Coupon coupon) throws CouponAlreadyExists {
		Coupon b = couponDao.addCoupon(coupon);
		if (b != null) {
			System.out.println("Coupon is created");
			logger.info("Created The Coupon Details");

			
		} else {
			System.out.println("not able to create Coupon object");
			logger.error("Unable to Create The Coupon Data");

		}
		return b;
	}
	
	//for retrieving the coupon details.
	@GetMapping(path = "/coupon")
	public List<Coupon> getCoupons() {
		logger.info("Fetched The Coupon");

		return couponDao.viewCoupons();
	}
	
	//for updating the coupon details.
	@PutMapping(path = "UpdateCoupon/coupon/{id}")
	public Coupon updateCoupon(@RequestBody @Valid Coupon coupon,@PathVariable int id) throws NoSuchCouponException {
		logger.info("Updated The Coupon Details");

		return this.couponDao.editCoupon(coupon);
	}
	
	//for deleting the already posted coupon.
	@DeleteMapping(path="DeleteCoupon/{id}")
	public Coupon deleteCoupon(@PathVariable int id) throws NoSuchCouponException{
		Coupon b=couponDao.findbyid(id);
		Coupon a=b;
		couponDao.deleteCoupon(b);
		logger.info("Deleted The Coupon Details based on Id");

		 return a;

	}
	@GetMapping(path = "/Coupon/{id}")
	public Coupon viewCouponById(@PathVariable int id) throws NoSuchCouponException {
		if(id==0)
		{		
		logger.info("Cant Fetch The Coupon Details");
		}
		logger.info("Fetched The Coupon Details Based On Id");
		return couponDao.findbyid(id);

	}
	
}
