package com.formypet.jpa.cart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.formypet.jpa.cart.dto.CartDto;
import com.formypet.jpa.cart.entity.Cart;
import com.formypet.jpa.cart.repository.CartRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	//cart생성
	@Override
	public Cart insert(Cart cart) {
		return cartRepository.save(cart);
	}
	
	//userId로 cart찾기
	@Override
	public Optional<Cart> findByUserId(Long id) {
		return cartRepository.findById(id);
	}
	
	//cart update
	@Override
	public CartDto updateCart(CartDto cartDto) throws Exception {
		Cart cart = cartRepository.findById(cartDto.getId()).orElse(null);
		
		cart.setCartTotalPrice(cartDto.getCartTotalPrice());
		cart.setCartTotalQty(cartDto.getCartTotalQty());
		
		Cart updatecart = cartRepository.save(cart);
		
		return CartDto.toDto(updatecart);
	}

	@Override
	public Optional<Cart> findByCartItemId(Long id) {
		return cartRepository.findByCartItemId(id);
	}
	
	
	
}
