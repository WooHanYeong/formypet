package com.formypet.jpa.cart.service;

import java.util.List;
import java.util.Optional;

import com.formypet.jpa.cart.dto.CartItemDto;
import com.formypet.jpa.cart.entity.CartItem;

public interface CartItemService {

	//cartItem 등록
	public CartItem insert(CartItem cartItem);
	
	//cartItem 삭제
	void deleteAllById(Iterable<Long> ids);
	
	//cartItem 리스트조회
	List<CartItem> findAllCartItemList();
	
	//cartItem수정
	CartItemDto updateCartItem(CartItemDto cartItemDto)throws Exception;
	
	//ids받아서 삭제할 리스트뽑기
	List<CartItem> findLongListCartItemList(List<Long> ids);
	
	public Optional<CartItem> findById(Long id);
	
}
