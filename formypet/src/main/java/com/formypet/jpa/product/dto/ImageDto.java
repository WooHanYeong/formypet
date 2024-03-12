package com.formypet.jpa.product.dto;

import com.formypet.jpa.product.entity.Image;

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
public class ImageDto {
	
	@Id
	private Long imageId;
	private String originImageName;
	private String imageName;
	private String imagePath;
	private Long productId;

	public Image toEntity() {
		Image build = Image.builder()
						   .imageId(imageId)
						   .originImageName(originImageName)
						   .imageName(imageName)
						   .imagePath(imagePath)
						   .build();
						   return build;
	}

	public static ImageDto toDto(Image entity) {
		return ImageDto.builder().originImageName(entity.getOriginImageName()).imageName(entity.getImageName())
				.imagePath(entity.getImagePath()).build();
	}

}
