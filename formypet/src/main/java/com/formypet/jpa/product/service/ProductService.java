package com.formypet.jpa.product.service;

import java.util.List;
import java.util.Optional;

import com.formypet.jpa.product.entity.Product;

public interface ProductService {
	
	//상품등록
	public Product insert(Product product);
	
	//강아지,고양이 카테고리 분류(최신순서)
	List<Product> findByProductAnimalType_OrderByCreatedTimeDesc(String productcategory);
	
	//강아지물품 카테고리 분류 (최신순서)
	List<Product> findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc(String animalType,String productcategory);

	Product increaseReadCount(Product product);
	
	public Optional<Product> findById(Long id);
}
