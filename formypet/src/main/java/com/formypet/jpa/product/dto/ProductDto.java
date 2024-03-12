package com.formypet.jpa.product.dto;

import com.formypet.jpa.product.entity.Image;
import com.formypet.jpa.product.entity.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
	
	@Id
    private Long id;

    private String productName;

    private String productContent;

    private String productAnimalType;

    private String productCategory;

    private String productPrice;

    private Long image;

    public static ProductDto toDto(Product entity) {
        return ProductDto.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .productContent(entity.getProductContent())
                .productAnimalType(entity.getProductAnimalType())
                .productCategory(entity.getProductCategory())
                .productPrice(entity.getProductPrice())
                .image(entity.getImage().getImageId())
                .build(); // 빌더로 객체 생성 후 반환
    }
    

}


