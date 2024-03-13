package com.formypet.jpa.board.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.formypet.jpa.board.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
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
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;
    
	
	
	public static BoardDto toDto(Board entity) {
		return  BoardDto.builder()
						.boardId(entity.getBoardId())
						.boardTitle(entity.getBoardTitle())
						.boardContent(entity.getBoardContent())
						.boardImage(entity.getBoardImage())
						.boardReadCount(entity.getBoardReadCount())
						.createdTime(entity.getCreatedTime())
						.updateTime(entity.getUpdateTime())
						.build();
	}
	
}
