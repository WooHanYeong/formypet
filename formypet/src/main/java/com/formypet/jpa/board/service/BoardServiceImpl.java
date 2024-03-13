package com.formypet.jpa.board.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formypet.jpa.board.dao.BoardDao;
import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.repository.BoardRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepository boardRepository;
/*
	@Override
	public Board createBoard(BoardDto boardDto) throws Exception {
		System.out.println("dto 확인"+boardDto);
		Board board = Board.builder()
							.boardTitle(boardDto.getBoardTitle())
							.boardContent(boardDto.getBoardContent())
							.boardImage(boardDto.getBoardImage())
							.boardReadCount(boardDto.getBoardReadCount())
							.build();
		System.out.println("board확인"+board);
		return boardRepository.save(board);
	}
*/
	@Override
	public Board insert(Board board){
		return boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long boardId) throws Exception {
		boardRepository.deleteById(boardId);
	}

	@Override
	public void updateBoard(Long boardId, BoardDto boardDto) throws Exception {
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
