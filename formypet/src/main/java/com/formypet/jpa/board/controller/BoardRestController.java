package com.formypet.jpa.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.service.BoardService;
import com.formypet.jpa.board.service.BoardServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {
	@Autowired
	BoardService boardService;

	/*
	 * @PostMapping("/create") public ResponseEntity<Board> createBoard(@RequestBody
	 * BoardDto boardDto) throws Exception { Board board =
	 * boardService.createBoard(boardDto); System.out.println("들어옴??"+board); return
	 * new ResponseEntity<>(board, HttpStatus.CREATED); }
	 */
	@PostMapping("/board_create")
	public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
		try {
			Board board = Board.toEntity(boardDto);
			Board createdBoard = boardService.createBoard(board);
			BoardDto createdBoardDto = BoardDto.toDto(createdBoard);
			return new ResponseEntity<>(createdBoardDto,HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{boardId}")
	public void deleteBoard(@PathVariable(value = "boardId") Long boardId) {
		try {
			boardService.deleteBoard(boardId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
