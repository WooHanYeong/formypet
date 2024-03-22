package com.formypet.jpa.cart.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.formypet.jpa.FormypetApplicationTest;
import com.formypet.jpa.cart.entity.Cart;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

import jakarta.transaction.Transactional;

public class CartServiceImplTest extends FormypetApplicationTest{

	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;
	
	@Test
	@Transactional
	@Rollback(false)
	void service()throws Exception{
		
		Long userId = (long) 1;
		User findUser = userService.findUserById(userId);
		System.out.println("findUser ==>" + findUser);
		Cart findCart = cartService.findByUserId(findUser.getId()).get();
		System.out.println("findCart -->" + findCart);
		
	}

	
}
