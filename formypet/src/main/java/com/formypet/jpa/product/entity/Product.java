package com.formypet.jpa.product.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.formypet.jpa.cart.entity.CartItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "product")
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String productName;
	
	private String productContent;
	
	private String productAnimalType;
	
	private String productCategory;
	
	private String productPrice;
	
	private String productImage;
	
	private int productReadCount;
	
	@CreationTimestamp
	private LocalDateTime createdTime;
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	//상품 - 댓글 관계설정
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@Builder.Default
	@ToString.Exclude
	private List<ProductReply> productReplyList =new ArrayList<>();
	
	//cartItem관계설정
	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<CartItem> cartItem = new ArrayList<>();
	
	
	/*
	 * public static Product toEntity(ProductDto dto) { Product product =
	 * Product.builder() .id(dto.getId()) .productName(dto.getProductName())
	 * .productContent(dto.getProductContent())
	 * .productAnimalType(dto.getProductAnimalType())
	 * .productCategory(dto.getProductCategory())
	 * .productPrice(dto.getProductPrice())
	 * .image(Image.builder().imageNo(dto.getId()).build()) .build(); return
	 * product; }
	 */
	
}
