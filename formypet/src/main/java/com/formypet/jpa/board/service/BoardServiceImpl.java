package com.formypet.jpa.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.repository.BoardRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public void createBoard(Board board) {
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);
	}

	@Override
	public void updateBoard(Long boardId, Board board) {
		Board findBoard = boardRepository.getById(boardId);
		findBoard.setBoardTitle(board.getBoardTitle());
		findBoard.setBoardContent(board.getBoardContent());
		findBoard.setBoardImage(board.getBoardImage());
		boardRepository.save(findBoard);
	}

}
