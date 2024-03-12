package com.formypet.jpa.product.entity;

import com.formypet.jpa.product.dto.ImageDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(length = 500, nullable = false)
    private String originImageName;

    @Column(length = 500, nullable = false)
    private String imageName;

    @Column(length = 1000, nullable = false)
    private String imagePath;
    
    public static Image toEntity(ImageDto dto) {
    	Image image = Image.builder()
    					   .imageId(dto.getImageId())
    					   .originImageName(dto.getOriginImageName())
    					   .imageName(dto.getImageName())
    					   .imagePath(dto.getImagePath())
    					   .product(Product.builder().id(dto.getProductId()).build())
    					   .build();
    	return image;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
