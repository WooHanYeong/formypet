package com.formypet.jpa.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formypet.jpa.product.entity.ProductReply;
import com.formypet.jpa.product.repository.ProductReplyRepository;

@Service
@Transactional
public class ProductReplyServiceImpl implements ProductReplyService{
	
	@Autowired
	private ProductReplyRepository productReplyRepository;
	
	//댓글등록
	@Override
	public ProductReply createReply(ProductReply productReply) {
		return productReplyRepository.save(productReply);
	}
	
	//상품아이디로 댓글리스트 가져오기(최신순서로 정렬 createdatetime)
	@Override
	public List<ProductReply> findByProduct_IdOrderByCreateDateTimeDesc(Long productId) {
		return productReplyRepository.findByProduct_IdOrderByCreateDateTimeDesc(productId);
	}
	
	//댓글삭제
	@Override
	public void deleteReply(Long id) {
		Optional<ProductReply> productReplyOptonal = productReplyRepository.findById(id);
		if(productReplyOptonal.isPresent()) {
			ProductReply productReply = productReplyOptonal.get();
			productReplyRepository.delete(productReply);
		}else {
	        System.out.println("삭제할 댓글이 존재하지 않습니다.");
		}
	}

}
