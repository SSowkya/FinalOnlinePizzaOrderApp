package com.cg.pizzaorder.service;

import java.util.List;

import com.cg.pizzaorder.exception.CouponAlreadyExists;
import com.cg.pizzaorder.exception.NoSuchCouponException;
import com.cg.pizzaorder.model.Coupon;

public interface ICouponService {
public Coupon addCoupon(Coupon coupon) throws CouponAlreadyExists;
public Coupon editCoupon(Coupon coupon) throws NoSuchCouponException;
public Coupon deleteCoupon(Coupon coupon) throws NoSuchCouponException;
public List<Coupon> viewCoupons();


}
