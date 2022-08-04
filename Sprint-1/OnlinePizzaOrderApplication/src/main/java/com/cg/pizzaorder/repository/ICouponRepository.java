package com.cg.pizzaorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.pizzaorder.model.Coupon;

@Repository
public interface ICouponRepository  extends JpaRepository<Coupon, Integer> {

}
