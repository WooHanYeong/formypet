package com.formypet.jpa.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.cart.service.CartItemService;
import com.formypet.jpa.cart.service.CartService;
import com.formypet.jpa.product.service.ProductService;
import com.formypet.jpa.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/cartItem2/")
public class CartItemRestController2 {

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;

	// cartItem 수량수정

	// cartItem 삭제
	@Operation(summary = "cartItem삭제[완료]")
	@DeleteMapping("/CartItemDelete")
	public ResponseEntity<String> deleteCartItem(@RequestBody List<Long> ids) {
		cartItemService.deleteAllById(ids);
		return ResponseEntity.ok("Products delete successfully.");
	}

}
