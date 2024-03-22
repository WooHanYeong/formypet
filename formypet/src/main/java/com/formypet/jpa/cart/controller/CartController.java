package com.formypet.jpa.cart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formypet.jpa.cart.entity.Cart;
import com.formypet.jpa.cart.entity.CartItem;
import com.formypet.jpa.cart.service.CartItemService;
import com.formypet.jpa.cart.service.CartService;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
@RequestMapping("/")

public class CartController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart_detail")
	public String cart_detail(HttpSession session,@RequestParam String userId, Model model) throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		Long loginuserId = loginUser.getId();
		Optional<Cart> findcart = cartService.findByUserId(loginUser.getCart().getId());
		Cart findcart2 = findcart.orElse(null);
		model.addAttribute("findcart2",findcart2);
		System.out.println("findcart2--->>"+findcart2);
		
		List<CartItem> cartItemList = cartItemService.findAllCartItemList();
		model.addAttribute("cartItemList",cartItemList);
		System.out.println("cartItemList--->>"+cartItemList);
		
		
		
		
		return "cart_detail";
	}
	
	
}
