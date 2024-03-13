package com.formypet.jpa.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public List<Product> findByProductAnimalType_OrderByCreatedTimeDesc(String productcategory) {
		return productRepository.findByProductAnimalType_OrderByCreatedTimeDesc(productcategory);
	}
	
}
