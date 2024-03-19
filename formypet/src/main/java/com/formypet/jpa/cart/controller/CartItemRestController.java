package com.formypet.jpa.cart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.cart.dto.CartDto;
import com.formypet.jpa.cart.dto.CartItemDto;
import com.formypet.jpa.cart.entity.Cart;
import com.formypet.jpa.cart.entity.CartItem;
import com.formypet.jpa.cart.service.CartItemService;
import com.formypet.jpa.cart.service.CartService;
import com.formypet.jpa.product.entity.Product;
import com.formypet.jpa.product.service.ProductService;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/cartItem/")
public class CartItemRestController {

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;

	// cartItem등록
	@Operation(summary = "cartItem등록")
	@PostMapping("/cartItemInsertDetail/{productId}")
	public ResponseEntity<String> insertCartItem(@PathVariable(value = "productId", required = false) Long productId,
			@RequestParam(value = "cartItemQty", required = false) int cartItemQty,
			@RequestParam(value = "userId", required = false) Long userId) throws Exception {
		// 로그인된 유저정보로 카트 가져오기
		User findUser = userService.findUserById(userId);
		Optional<Cart> findCart = cartService.findByUserId(userId);
		Long findCartId = null;

		// 카트가 존재하지않으면 만들고 cartId찾기
		if (!findCart.isPresent()) {
			Cart newCart = new Cart();
			newCart.setUser(findUser);
			newCart.setCartTotalPrice(0);
			newCart.setCartTotalQty(0);

			cartService.insert(newCart);
			findCartId = newCart.getId();
		} else {
			findCartId = findCart.get().getId();
		}

		// product찾기
		Product findProduct = productService.findById(productId).orElse(null);
		Cart findcart2 = findCart.orElse(null); // Optional 객체가 비어있으면 null을 반환

		// DB Insert
		try {
			// cartIteminsert
			CartItem cartItem = new CartItem(null, cartItemQty, findcart2, findProduct);
			cartItemService.insert(cartItem);

			// cart update
			findcart2.setCartTotalPrice(findcart2.getCartTotalPrice() + (findProduct.getProductPrice()) * cartItemQty);
			findcart2.setCartTotalQty(findcart2.getCartTotalQty() + cartItemQty);
			CartDto findcart2Dto = CartDto.toDto(findcart2);
			cartService.updateCart(findcart2Dto);

			return ResponseEntity.ok("cartItem 성공");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload cartItem.");
		}

	}

	// cartItem등록2
	@Operation(summary = "cartItem등록")
	@PostMapping("/cartItemInsertList/{productId}")
	public ResponseEntity<String> cartItemInsertList(@RequestParam(value = "productId") Long productId,
			@RequestParam(value = "userId") Long userId) {
		try {
			// 로그인된 유저정보로 카트 가져오기
			User findUser = userService.findUserById(userId);
			Optional<Cart> findCart = cartService.findByUserId(userId);
			Cart findCart2 = findCart.orElseGet(() -> {
				Cart newCart = new Cart();
				newCart.setUser(findUser);
				newCart.setCartTotalPrice(0);
				newCart.setCartTotalQty(0);
				cartService.insert(newCart);
				return newCart;
			});

			// product찾기
			Product findProduct = productService.findById(productId).orElse(null);

			if (findProduct == null || findCart2 == null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to find product or cart.");
			}

			// 이미 카트에 해당 상품이 존재하는지 확인
			Optional<CartItem> existingCartItem = findCart2.getCartItem().stream()
					.filter(cartItem -> cartItem.getProduct().getId().equals(productId)).findFirst();

			if (existingCartItem.isPresent()) {
				// 이미 카트에 해당 상품이 존재하는 경우에는 수량만 증가
				CartItem cartItem = existingCartItem.get();
				int cartItemQty = cartItem.getCartItemQty() + 1;
				cartItem.setCartItemQty(cartItemQty);
				CartItemDto cartItemDto = CartItemDto.toDto(cartItem);
				cartItemService.updateCartItem(cartItemDto);
			} else {
				// 새로운 아이템으로 등록
				int cartItemQty = 1;
				CartItem cartItem = new CartItem(null, cartItemQty, findCart2, findProduct);
				cartItemService.insert(cartItem);
			}

			// cart update
			findCart2.setCartTotalPrice(findCart2.getCartTotalPrice() + findProduct.getProductPrice());
			findCart2.setCartTotalQty(findCart2.getCartTotalQty() + 1);
			CartDto findcart2Dto = CartDto.toDto(findCart2);
			cartService.updateCart(findcart2Dto);

			return ResponseEntity.ok("CartItem 성공");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload cartItem.");
		}
	}

}
