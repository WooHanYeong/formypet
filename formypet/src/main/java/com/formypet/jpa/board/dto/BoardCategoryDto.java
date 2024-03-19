package com.formypet.jpa.board.dto;
import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.entity.BoardSubCategory;

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
public class BoardCategoryDto {
	
	private Long categoryId;    
	private String categoryName;
	private BoardSubCategory boardSubCategory;
	
	public static BoardCategoryDto toDto(BoardCategory entity) {
		return BoardCategoryDto.builder()
								.categoryId(entity.getCategoryId())
								.categoryName(entity.getCategoryName())
								.build();
	}

	
}