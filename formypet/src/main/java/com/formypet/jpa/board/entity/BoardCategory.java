package com.formypet.jpa.board.entity;

import java.util.ArrayList;
import java.util.List;

import com.formypet.jpa.board.dto.BoardCategoryDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class BoardCategory {
	
	@Id
	@SequenceGenerator(name = "BOARD_CATEGORY_NO_SEQ",sequenceName = "BOARD_CATEGORY_NO_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BOARD_CATEGORY_NO_SEQ")
	private Long categoryId;
	private String categoryName;
	
	public static BoardCategory toEntity(BoardCategoryDto dto) {
		return BoardCategory.builder()
							.categoryId(dto.getCategoryId())
							.categoryName(dto.getCategoryName())
							.build();
	}

	@OneToMany(mappedBy = "boardCategory",cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<Board> boards = new ArrayList<Board>();
	
	@OneToMany(mappedBy = "boardCategory",cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<BoardSubCategory> subCategories = new ArrayList<BoardSubCategory>();
	
}
