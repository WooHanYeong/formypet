package com.formypet.jpa.cart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	Optional<Cart> findByUserId(Long userId);

	Optional<Cart> findByCartItemId(Long cartItemId);
}
