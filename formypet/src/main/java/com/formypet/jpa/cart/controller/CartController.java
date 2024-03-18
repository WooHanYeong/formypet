package com.formypet.jpa.cart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping("/")

public class CartController {
	@GetMapping("/cart_detail")
	public String cart_detail(@RequestParam String userId, Model model) {
		
		return "cart_detail";
	}
}
