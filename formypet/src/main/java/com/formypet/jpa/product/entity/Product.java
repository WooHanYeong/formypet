package com.formypet.jpa.product.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.formypet.jpa.product.dto.ProductDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	private int product_ReadCount;
	
	@CreationTimestamp
	private LocalDateTime createdTime;
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	
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
