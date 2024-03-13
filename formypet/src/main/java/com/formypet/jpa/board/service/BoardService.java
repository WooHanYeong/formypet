package com.formypet.jpa.board.service;


import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;

public interface BoardService {
	
	public Board createBoard(Board board) throws Exception;

	public void deleteBoard(Long boardId) throws Exception;
	
	public void updateBoard(Long boardId,BoardDto boardDto) throws Exception;
	
	
}
