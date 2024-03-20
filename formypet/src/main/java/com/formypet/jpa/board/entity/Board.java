package com.formypet.jpa.board.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.formypet.jpa.board.dto.BoardDto;

import jakarta.persistence.Column;
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
public class Board {
	
	@Id
	@SequenceGenerator(name = "BOARD_BOARD_NO_SEQ",sequenceName = "BOARD_BOARD_NO_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BOARD_BOARD_NO_SEQ")
	private Long boardId;
	private String boardTitle;
	@Column(columnDefinition = "CLOB")
	private String boardContent;
	private String boardImage;
	private int boardReadCount; 
	private int boardRecommend;
	
	@CreationTimestamp
	private LocalDateTime createdTime;
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	
	public static Board toEntity(BoardDto dto) {
		Board board= Board.builder()
					.boardId(dto.getBoardId())
					.boardTitle(dto.getBoardTitle())
					.boardContent(dto.getBoardContent())
					.boardImage(dto.getBoardImage())
					.boardReadCount(dto.getBoardReadCount())
					.boardRecommend(dto.getBoardRecommend())
					.boardCategory(BoardCategory.builder().categoryId(dto.getBoardCategoryId()).build())
					.boardSubCategory(BoardSubCategory.builder().subCategoryId(dto.getBoardSubCategoryId()).build())
					.build();
		return board;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	@ToString.Exclude
	private BoardCategory boardCategory;
	
	@ManyToOne
	@JoinColumn(name = "sub_category_id")
	@ToString.Exclude
	private BoardSubCategory boardSubCategory;
	
	

	
}
