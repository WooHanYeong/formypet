package com.formypet.jpa.product.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.formypet.jpa.product.dto.ProductReplyDto;
import com.formypet.jpa.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product_reply")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductReply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productReplyId;

	private String productReplyTitle;

	private String productReplyContent;

	@CreationTimestamp
	private LocalDateTime createDateTime;
	
	public static ProductReply toEntity(ProductReplyDto dto) {
		return ProductReply.builder()
						   .productReplyId(dto.getProductReplyId())
						   .productReplyTitle(dto.getProductReplyTitle())
						   .productReplyContent(dto.getProductReplyContent())
						   .product(Product.builder().id(dto.getProductId()).build())
						   .user(User.builder().id(dto.getUserId()).build())
						   .build();
	}
	//상품 - 댓글 관계설정
	@ManyToOne
	@JoinColumn(name="product_id") // 외래 키 컬럼명 지정
	@ToString.Exclude
	private Product product;

	
	//유저 - 댓글 관계설정
	@ManyToOne
	@JoinColumn(name="user_id") // 외래 키 컬럼명 지정
	@ToString.Exclude
	private User user;

}
