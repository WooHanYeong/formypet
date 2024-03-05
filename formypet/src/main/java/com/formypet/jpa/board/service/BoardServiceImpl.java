package com.formypet.jpa.board.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.repository.BoardRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public Board createBoard(Board board) {
		Board saveBoard = boardRepository.save(board);
		return saveBoard;
	}

	@Override
	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);
	}

	@Override
	public void updateBoard(Long boardId, BoardDto boardDto) {
		Optional<Board> optionalBoard = boardRepository.findById(boardId);
		if (optionalBoard.isPresent()) {
			Board findBoard = optionalBoard.get();
			findBoard.setBoardTitle(boardDto.getBoardTitle());
			findBoard.setBoardContent(boardDto.getBoardContent());
			findBoard.setBoardImage(boardDto.getBoardImage());
			boardRepository.save(findBoard);
		} else {
			System.out.println("보드에러발생");
		}
	}

}
