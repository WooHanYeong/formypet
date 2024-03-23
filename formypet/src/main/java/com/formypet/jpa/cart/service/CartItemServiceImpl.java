package com.formypet.jpa.cart.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formypet.jpa.cart.dto.CartDto;
import com.formypet.jpa.cart.dto.CartItemDto;
import com.formypet.jpa.cart.entity.CartItem;
import com.formypet.jpa.cart.repository.CartItemRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;

	//cartItem등록
	@Override
	public CartItem insert(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}
	
	//cartItem삭제(1개이상)
	@Override
	public void deleteAllById(Iterable<Long> ids) {
		cartItemRepository.deleteAllById(ids);
	}
	
	//cartItem리스트
	@Override
	public List<CartItem> findAllCartItemList() {
	    List<CartItem> cartItems = cartItemRepository.findAll();
	    return cartItems != null ? cartItems : Collections.emptyList();
	}

	//cartItem수정
	@Override
	public CartItemDto updateCartItem(CartItemDto cartItemDto) throws Exception {
		CartItem cartItem =cartItemRepository.findById(cartItemDto.getId()).orElse(null);
		
		cartItem.setCartItemQty(cartItemDto.getCartItemQty());
		
		CartItem updateCartItem = cartItemRepository.save(cartItem);
		
		return CartItemDto.toDto(updateCartItem);
	}
	
	//ids받아서 삭제리스트.
	@Override
	public List<CartItem> findLongListCartItemList(List<Long> ids) {
		return cartItemRepository.findAllById(ids);
	}

	@Override
	public Optional<CartItem> findById(Long id) {
		return cartItemRepository.findById(id);
	}


	
}
