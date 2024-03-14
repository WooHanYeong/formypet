package com.formypet.jpa.product.service;

import java.util.List;

import com.formypet.jpa.product.entity.ProductReply;

public interface ProductReplyService {
	
	//댓글등록
	ProductReply createReply(ProductReply productReply);
	
	//상품아이디로 댓글리스트 가져오기(최신순서로 정렬 createdatetime)
	public List<ProductReply> findByProduct_IdOrderByCreateDateTimeDesc(Long productId);
	
	//댓글삭제
	public void deleteReply(Long id);
	
}
