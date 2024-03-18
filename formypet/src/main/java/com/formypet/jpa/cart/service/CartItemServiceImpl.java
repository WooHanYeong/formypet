package com.formypet.jpa.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		return cartItemRepository.findAll();
	}

	//cartItem수정
	
}
