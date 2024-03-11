package com.formypet.jpa.product.dto;

import com.formypet.jpa.product.entity.Image;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImageDto {

    private String originImageName;
    private String imageName;
    private String imagePath;

    public Image toEntity() {
        Image build = Image.builder()
                .originImageName(originImageName)
                .imageName(imageName)
                .imagePath(imagePath)
                .build();
        return build;
    }

    @Builder
    public ImageDto (String originImageName, String imageName,String imagePath) {
        this.originImageName = originImageName;
        this.imageName = imageName;
        this.imagePath = imagePath;
    }

}
