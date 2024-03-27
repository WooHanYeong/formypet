package com.formypet.jpa.board.dto;

import com.formypet.jpa.board.entity.BoardReply;

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
public class BoardReplyDto {
	private Long replyId;
	private String replyContent;
	
	private Long userId;
	private Long boardId;
	
	public static BoardReplyDto toDto(BoardReply entity) {
		return BoardReplyDto.builder()
							.replyId(entity.getReplyId())
							.replyContent(entity.getReplyContent())
							.userId(entity.getUser().getId())
							.boardId(entity.getBoard().getBoardId())
							.build();
	}
}
