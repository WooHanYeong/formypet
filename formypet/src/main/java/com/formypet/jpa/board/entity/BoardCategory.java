package com.formypet.jpa.board.entity;

import com.formypet.jpa.board.dto.BoardCategoryDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardCategory {
	
	@Id
	@SequenceGenerator(name = "BOARDCATEGORY_BOARDCATEGORY_NO_SEQ",sequenceName = "BOARDCATEGORY_BOARDCATEGORY_NO_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BOARDCATEGORY_BOARDCATEGORY_NO_SEQ")
	private Long categoryId;
	private String categoryName;
	
	public static BoardCategory toEntity(BoardCategoryDto dto) {
		return BoardCategory.builder()
							.categoryId(dto.getCategoryId())
							.categoryName(dto.getCategoryName())
							.build();
	}
	
}
