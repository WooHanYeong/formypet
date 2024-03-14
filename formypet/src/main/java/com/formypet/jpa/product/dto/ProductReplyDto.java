package com.formypet.jpa.product.dto;

import com.formypet.jpa.product.entity.ProductReply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductReplyDto {

	private Long productReplyId;
	private String productReplyTitle;
	private String productReplyContent;
	private Long userId;
	private Long productId;
	
	//DTO설정.
	public static ProductReplyDto toDto(ProductReply entity) {
		return ProductReplyDto.builder()
							  .productReplyId(entity.getProductReplyId())
							  .productReplyTitle(entity.getProductReplyTitle())
							  .productReplyContent(entity.getProductReplyContent())
							  .productId(entity.getProduct().getId())
							  .userId(entity.getUser().getId())
							  .build();
	}
}
