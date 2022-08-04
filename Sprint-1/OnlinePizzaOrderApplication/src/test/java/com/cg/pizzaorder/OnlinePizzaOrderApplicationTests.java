package com.cg.pizzaorder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.pizzaorder.dao.AdminDao;
import com.cg.pizzaorder.dao.CouponDao;
import com.cg.pizzaorder.model.Admin;
import com.cg.pizzaorder.model.Coupon;
import com.cg.pizzaorder.repository.IAdminRepository;
import com.cg.pizzaorder.repository.ICouponRepository;

import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
@ExtendWith(MockitoExtension.class)

class OnlinePizzaOrderApplicationTests {
	@InjectMocks
	private AdminDao  adminservice;
	@MockBean
	private IAdminRepository adminrepo;

	@Test
	 void test_addadmin() {
	   
		Admin c = new Admin();
		c.setAdminId(6);
		c.setAdminName("Ram");
		c.setAdminPassword("ram12345");
		
		
		Mockito.when(adminrepo.save(c)).thenReturn(c);
		Admin result = adminrepo.save(c);
		assertEquals(6, result.getAdminId());
	}


	@Test
	 void test_viewAlladmins()  {
		new Admin();
		Mockito.when(adminrepo.findAll())
				.thenReturn(Stream.of(new Admin()).collect(Collectors.toList()));
		assertEquals(1,adminservice.viewAdmins().size());
		
		
		
		
	
	}

}
	
