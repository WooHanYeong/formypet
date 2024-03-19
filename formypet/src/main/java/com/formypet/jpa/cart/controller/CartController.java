package com.formypet.jpa.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formypet.jpa.cart.entity.CartItem;
import com.formypet.jpa.cart.service.CartItemService;

@org.springframework.stereotype.Controller
@RequestMapping("/")

public class CartController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@GetMapping("/cart_detail")
	public String cart_detail(@RequestParam String userId, Model model) {
		
		List<CartItem> cartItemList = cartItemService.findAllCartItemList();
		model.addAttribute("cartItemList",cartItemList);
		
		
		
		return "cart_detail";
	}
	
	
}
