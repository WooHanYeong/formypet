package com.formypet.jpa.board.service;


import com.formypet.jpa.board.entity.Board;

public interface BoardService {
	
	public void createBoard(Board board);
	
	public void deleteBoard(Long boardId);
	
	public void updateBoard(Long boardId,Board board);
	
	
}
