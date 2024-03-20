package com.formypet.jpa.board.dto;

import com.formypet.jpa.board.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDto {
	
	private Long boardId;
	private String boardTitle;
	private String boardContent;
	private String boardImage;
	private int boardReadCount;
	private int boardRecommend;

	private Long boardCategoryId;
	private Long boardSubCategoryId;
	
	public static BoardDto toDto(Board entity) {
		return  BoardDto.builder()
						.boardId(entity.getBoardId())
						.boardTitle(entity.getBoardTitle())
						.boardContent(entity.getBoardContent())
						.boardImage(entity.getBoardImage())
						.boardReadCount(entity.getBoardReadCount())
						.boardRecommend(entity.getBoardRecommend())
						.boardCategoryId(entity.getBoardCategory().getCategoryId())
						.boardSubCategoryId(entity.getBoardSubCategory().getSubCategoryId())
						.build();
	}
	
}