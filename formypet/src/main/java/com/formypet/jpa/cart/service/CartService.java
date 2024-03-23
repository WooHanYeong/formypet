package com.formypet.jpa.cart.service;

import java.util.Optional;

import com.formypet.jpa.cart.dto.CartDto;
import com.formypet.jpa.cart.entity.Cart;

public interface CartService {

	//cart등록
	public Cart insert(Cart cart);
	
	//cart찾기
	public Optional<Cart> findByUserId(Long id);
	
	//cart찾기(아이템으로)
	public Optional<Cart> findByCartItemId(Long id);
	
	
	
	//cart 수정
	CartDto updateCart(CartDto cartDto)throws Exception;
	
}
