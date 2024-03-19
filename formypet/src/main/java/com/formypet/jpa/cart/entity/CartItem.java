package com.formypet.jpa.cart.entity;

import com.formypet.jpa.cart.dto.CartItemDto;
import com.formypet.jpa.product.entity.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int cartItemQty;
	
	//cart관계설정
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
	@ToString.Exclude
    private Cart cart;
	
	
	//product관계설정
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
	
	public static CartItem toEntity(CartItemDto dto) {
		return CartItem.builder()
				   .id(dto.getId())
				   .cartItemQty(dto.getCartItemQty())
				   .build();
	}
}
