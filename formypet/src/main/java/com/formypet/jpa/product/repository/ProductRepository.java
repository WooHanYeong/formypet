package com.formypet.jpa.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	//강아지,고양이 카테고리 분류(최신순서)
	List<Product> findByProductAnimalType_OrderByCreatedTimeDesc(String productcategory);

}
