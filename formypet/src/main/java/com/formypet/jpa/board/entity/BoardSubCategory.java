package com.formypet.jpa.board.entity;


import com.formypet.jpa.board.dto.BoardSubCategoryDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardSubCategory {
	
	@Id
	@SequenceGenerator(name = "BOARD_SUB_CATEGORY_NO_SEQ",sequenceName = "BOARD_SUB_CATEGORY_NO_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BOARD_SUB_CATEGORY_NO_SEQ")
	private Long subCategoryId;
	private String subCategoryName;
	
	public static BoardSubCategory toEntity(BoardSubCategoryDto dto) {
		return BoardSubCategory.builder()
							.subCategoryId(dto.getSubCategoryId())
							.subCategoryName(dto.getSubCategoryName())
							.build();
	}
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	@ToString.Exclude
	private BoardCategory boardCategory;
	
}
