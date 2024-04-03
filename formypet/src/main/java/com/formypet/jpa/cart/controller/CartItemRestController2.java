package com.formypet.jpa.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.cart.dto.CartDto;
import com.formypet.jpa.cart.entity.Cart;
import com.formypet.jpa.cart.entity.CartItem;
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

	// cartItem 수량수정+
	@Operation(summary = "cartItem+1")
	@PostMapping("CartItemUpdateP")
	public ResponseEntity<String> CartItemUpdateP(@RequestBody List<Long> ids) throws Exception {

		List<CartItem> cartItemList = cartItemService.findLongListCartItemList(ids);
		for (CartItem cartItem : cartItemList) {
			CartItem findcartItem = cartItemService.findById(cartItem.getId()).get();
			findcartItem.setCartItemQty(findcartItem.getCartItemQty() + 1);

			Cart findCart = cartService.findByCartItemId(findcartItem.getId()).get();
			findCart.setCartTotalQty(findCart.getCartTotalQty() + 1);
			findCart.setCartTotalPrice(findCart.getCartTotalPrice() + findcartItem.getProduct().getProductPrice());
			CartDto findCartDto = CartDto.toDto(findCart);
			cartService.updateCart(findCartDto);

		}
		return ResponseEntity.ok("Products update successfully.");
	}

	// cartItem 수량수정-
	@Operation(summary = "cartItem-1")
	@PostMapping("CartItemUpdateM")
	public ResponseEntity<String> CartItemUpdateM(@RequestBody List<Long> ids) throws Exception {

		List<CartItem> cartItemList = cartItemService.findLongListCartItemList(ids);
		for (CartItem cartItem : cartItemList) {
			CartItem findcartItem = cartItemService.findById(cartItem.getId()).get();
			findcartItem.setCartItemQty(findcartItem.getCartItemQty() -1);

			Cart findCart = cartService.findByCartItemId(findcartItem.getId()).get();
			findCart.setCartTotalQty(findCart.getCartTotalQty() -1 );
			findCart.setCartTotalPrice(findCart.getCartTotalPrice() - findcartItem.getProduct().getProductPrice());
			CartDto findCartDto = CartDto.toDto(findCart);
			cartService.updateCart(findCartDto);

		}
		return ResponseEntity.ok("Products update successfully.");
	}

	// cartItem 삭제
	@Operation(summary = "cartItem삭제[완료]")
	@DeleteMapping("/CartItemDelete")
	public ResponseEntity<String> deleteCartItem(@RequestBody List<Long> ids) throws Exception {

		List<CartItem> cartItemList = cartItemService.findLongListCartItemList(ids);
		for (CartItem cartItem : cartItemList) {
			Cart findCart = cartService.findByCartItemId(cartItem.getId()).get();
			findCart.setCartTotalQty(findCart.getCartTotalQty() - cartItem.getCartItemQty());
			findCart.setCartTotalPrice(findCart.getCartTotalPrice()
					- (cartItem.getCartItemQty() * cartItem.getProduct().getProductPrice()));
			CartDto findCartDto = CartDto.toDto(findCart);
			cartService.updateCart(findCartDto);

			cartItemService.deleteAllById(ids);

		}

		return ResponseEntity.ok("Products delete successfully.");
	}

}
