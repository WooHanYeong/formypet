package com.formypet.jpa.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.product.entity.ProductReply;

public interface ProductReplyRepository extends JpaRepository<ProductReply, Long>{
	
	//상품아이디로 댓글리스트 가져오기(최신순서로 정렬 createdatetime)
	List<ProductReply> findByProduct_IdOrderByCreateDateTimeDesc(Long id);
}
