package com.formypet.jpa.cart.entity;

import java.util.ArrayList;
import java.util.List;

import com.formypet.jpa.cart.dto.CartDto;
import com.formypet.jpa.user.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
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
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int cartTotalPrice;

	private int cartTotalQty;

	public static Cart toEntity(CartDto dto) {
		return Cart.builder().id(dto.getId()).cartTotalPrice(dto.getCartTotalPrice())
				.cartTotalQty(dto.getCartTotalQty()).build();
	}

	// 유저관계설정
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;

	// cartItem관계설정
	@OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<CartItem> cartItem = new ArrayList<>();

	// product관계설정
}
