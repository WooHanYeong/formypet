package com.formypet.jpa.board.dto;
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
public class BoardSubCategoryDto {
	
	private Long subCategoryId;    
	private String subCategoryName;
	private Long categoryId;
	
	public static BoardSubCategoryDto toDto(BoardSubCategory entity) {
		return BoardSubCategoryDto.builder()
								.subCategoryId(entity.getSubCategoryId())
								.subCategoryName(entity.getSubCategoryName())
								.build();
	}

	
}