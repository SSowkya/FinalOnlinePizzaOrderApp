package com.cg.pizzaorder.dao;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pizzaorder.exception.CouponAlreadyExists;
import com.cg.pizzaorder.exception.NoSuchCouponException;
import com.cg.pizzaorder.model.Coupon;
import com.cg.pizzaorder.repository.ICouponRepository;
import com.cg.pizzaorder.service.ICouponService;

@Service
public class CouponDao implements ICouponService {
	@Autowired
	ICouponRepository couponRepository;

	@Autowired
	AdminDao adminDao;

	Logger logger = org.slf4j.LoggerFactory.getLogger(CouponDao.class);

	public String readInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Admin Details to Login");
		System.out.println("Enter Admin Id");
		int adminId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Admin name");
		String adminName = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		scanner.close();

		return adminId + " " + adminName + " " + password;
	}

	// to add the coupon
	@Override
	public Coupon addCoupon(Coupon coupon) throws CouponAlreadyExists {

		if (couponRepository.existsById(coupon.getCouponId())) {
			logger.error("Coupon already exists exception");
			throw new CouponAlreadyExists("Coupon already exists");
		} else {
			logger.info("Coupon added successfully");
			return couponRepository.save(coupon);
		}

	}

	// to delete the coupon
	@Override
	public Coupon deleteCoupon(Coupon coupon) throws NoSuchCouponException {
		Optional<Coupon> optional = couponRepository.findById(coupon.getCouponId());
		if (optional.isPresent()) {
			couponRepository.delete(coupon);

		} else {
			throw new NoSuchCouponException("Coupon Data couldn't be Deleted!,No Such Id Exists ");
		}
		logger.info("Coupon Deleted successfully");
		return coupon;

	}

	// to view the coupons list
	@Override
	public List<Coupon> viewCoupons() {
		List<Coupon> list = couponRepository.findAll();
		for (Coupon c : list)
			logger.info(c.getCouponId() + " " + c.getCouponName() + " " + c.getCouponType() + " "
					+ c.getCouponDescription() + " " + c.getCouponPizzaId());
		return list;
	}

	// to update the coupon
	@Override
	public Coupon editCoupon(Coupon coupon) throws NoSuchCouponException {
		Optional<Coupon> optional = couponRepository.findById(coupon.getCouponId());
		if (optional.isPresent()) {
			couponRepository.save(coupon);

		} else {
			throw new NoSuchCouponException("Coupon Data couldn't be Updated! ");
		}
		return coupon;
	}

	public Coupon findbyid(int id) throws NoSuchCouponException {
		return couponRepository.findById(id).orElseThrow(() -> new NoSuchCouponException("Coupon does not exist"));

	}

}
