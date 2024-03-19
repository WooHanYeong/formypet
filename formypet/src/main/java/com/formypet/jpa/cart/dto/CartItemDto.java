package com.formypet.jpa.cart.dto;

import com.formypet.jpa.cart.entity.CartItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CartItemDto {
	private Long id;
	
	private int cartItemQty;
	
	public static CartItemDto toDto(CartItem entity) {
		return CartItemDto.builder()
						  .id(entity.getId())
						  .cartItemQty(entity.getCartItemQty())
						  .build();
	}
}
