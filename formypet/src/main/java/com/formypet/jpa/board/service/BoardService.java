package com.formypet.jpa.board.service;


import java.util.List;
import java.util.Optional;

import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.entity.BoardSubCategory;

public interface BoardService {
	
	//게시판 글작성
	public Board createBoard(BoardDto boardDto) throws Exception;

	//게시판 글삭제
	public void deleteBoard(Long boardId) throws Exception;
	
	//게시판 글수정
	public Board updateBoard(Long boardId,BoardDto boardDto) throws Exception;
	
	//게시판 글 모두 조회
	public List<Board> getBoardByAll() throws Exception;
	

	
}
