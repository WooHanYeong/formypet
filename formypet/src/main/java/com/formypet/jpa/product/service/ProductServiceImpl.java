package com.formypet.jpa.product.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.formypet.jpa.product.entity.Product;
import com.formypet.jpa.product.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product insert(Product product) {
		return productRepository.save(product);
	}
	
}
