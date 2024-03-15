package com.formypet.jpa.board.service;


import java.util.List;
import java.util.Optional;

import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;

public interface BoardService {
	

	public Board createBoard(BoardDto boardDto) throws Exception;

	public void deleteBoard(Long boardId) throws Exception;
	
	public Board updateBoard(Long boardId,BoardDto boardDto) throws Exception;
	
	public Optional<Board> getBoardById(Long boardId) throws Exception;
	
	public List<Board> getBoardByAll() throws Exception;
	
	public List<Board> getBoardByCategoryId(Long categoryId) throws Exception;
	
	public List<Board> getBoardByCategoryName(String categoryName) throws Exception;
	
}
