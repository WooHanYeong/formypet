package com.formypet.jpa.cart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")

public class CartController {
	@GetMapping("/cart_detail")
	public String cart_detail() {
		String forwardPath = "cart_detail";
		return forwardPath;
	}
}
