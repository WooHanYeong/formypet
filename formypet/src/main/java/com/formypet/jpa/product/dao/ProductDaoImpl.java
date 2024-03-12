package com.formypet.jpa.product.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formypet.jpa.product.entity.Product;
import com.formypet.jpa.product.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product insertProduct(Product product) {
		Product saveProduct = productRepository.save(product);
		return saveProduct;
	}

}
