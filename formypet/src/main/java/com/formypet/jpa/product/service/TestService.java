package com.formypet.jpa.product.service;

import org.springframework.stereotype.Service;

import com.formypet.jpa.product.dto.ImageDto;
import com.formypet.jpa.product.repository.ImageRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

    private final ImageRepository imageRepository;

    @Transactional
    public Long saveImage(ImageDto imageDto) {
        return imageRepository.save(imageDto.toEntity()).getImageNo();
    }
}
