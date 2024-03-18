package com.formypet.jpa.cart.service;

import java.util.List;

import com.formypet.jpa.cart.entity.CartItem;

public interface CartItemService {

	//cartItem 등록
	public CartItem insert(CartItem cartItem);
	
	//cartItem 삭제
	void deleteAllById(Iterable<Long> ids);
	
	//cartItem 리스트조회
	List<CartItem> findAllCartItemList();
	
	//cartItem수정
	
	
}
