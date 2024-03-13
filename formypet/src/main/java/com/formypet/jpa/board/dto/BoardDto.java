package com.formypet.jpa.board.dto;

import com.formypet.jpa.board.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardDto {
	private Long boardId;
	
	private String boardTitle;
	private String boardContent;
	private String boardImage;
	private int boardReadCount;

	
	public static BoardDto toDto(Board entity) {
		BoardDto boardDto = BoardDto.builder()
						.boardId(entity.getBoardId())
						.boardTitle(entity.getBoardTitle())
						.boardContent(entity.getBoardContent())
						.boardImage(entity.getBoardImage())
						.boardReadCount(entity.getBoardReadCount())
						.build();
		return boardDto;
	}
	
}
