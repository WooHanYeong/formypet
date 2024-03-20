package com.formypet.jpa.board.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.service.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {
	@Autowired
	BoardService boardService;

	@DeleteMapping("/delete/{boardId}")
	public void deleteBoard(@PathVariable(value = "boardId") Long boardId) {
		try {
			boardService.deleteBoard(boardId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostMapping("/create/{categoryId}/{subCategoryId}")
	public ResponseEntity<Board> createBoardForList(@PathVariable(value = "subCategoryId") Long subCategoryId,@PathVariable(value = "categoryId") Long categoryId,@RequestBody BoardDto boardDto) throws Exception {
		Board board = boardService.createBoardByMainCategoryBySubCategory(boardDto);
		return new ResponseEntity<>(board, HttpStatus.CREATED);
	}

	@PutMapping("/update/{boardId}")
	public ResponseEntity<String> updateBoard(@PathVariable(value = "boardId") Long boardId,
			@RequestBody BoardDto boardDto) {
		try {
			boardService.updateBoard(boardId, boardDto);
			return new ResponseEntity<>("boardId : " + boardId + "업데이트 성공", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("boardId : " + boardId + "를 찾을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
