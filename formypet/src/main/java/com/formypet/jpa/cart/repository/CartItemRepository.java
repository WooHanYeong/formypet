package com.formypet.jpa.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.cart.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
