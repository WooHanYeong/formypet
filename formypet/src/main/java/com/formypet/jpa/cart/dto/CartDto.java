package com.formypet.jpa.cart.dto;


import com.formypet.jpa.cart.entity.Cart;

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
public class CartDto {

	private Long id;

	private int cartTotalPrice;

	private int cartTotalQty;
	
	public static CartDto toDto(Cart entity) {
		return CartDto.builder()
					  .id(entity.getId())
					  .cartTotalPrice(entity.getCartTotalPrice())
					  .cartTotalQty(entity.getCartTotalQty())
					  .build();
	}
}
