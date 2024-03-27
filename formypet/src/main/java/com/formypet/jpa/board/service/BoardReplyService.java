package com.formypet.jpa.board.service;

import java.util.List;

import com.formypet.jpa.board.dto.BoardReplyDto;
import com.formypet.jpa.board.entity.BoardReply;

public interface BoardReplyService {
	
	BoardReply createReply(BoardReplyDto boardReplyDto);
	void deleteReply(Long replyId);
	List<BoardReply> findReplyByBoardId(Long boardId)throws Exception; 
}
