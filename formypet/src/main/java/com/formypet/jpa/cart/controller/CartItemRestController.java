package com.formypet.jpa.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.cart.service.CartItemService;

@RestController
@RequestMapping("api/cartItem/")
public class CartItemRestController {

	@Autowired
	private CartItemService cartItemService;
	
	
	
}
