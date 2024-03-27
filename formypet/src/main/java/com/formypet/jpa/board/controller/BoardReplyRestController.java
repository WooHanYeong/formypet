package com.formypet.jpa.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.board.dto.BoardReplyDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardReply;
import com.formypet.jpa.board.service.BoardReplyService;
import com.formypet.jpa.board.service.BoardService;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

@RestController
@RequestMapping("api/boardReply")
public class BoardReplyRestController {
	@Autowired
	private UserService userService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardReplyService boardReplyService;

	@PostMapping("/insert_reply/{boardId}")
	public ResponseEntity<BoardReply> insertReply(@PathVariable(value = "boardId") Long boardId,
			@RequestBody BoardReplyDto boardReplyDto, @RequestParam(value = "userId") Long userId) {
		BoardReply reply = boardReplyService.createReply(boardReplyDto);
		return new ResponseEntity<>(reply, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete_reply/{replyId}")
	public void boardReplyDelete(@PathVariable(name="replyId") Long replyId) {
		boardReplyService.deleteReply(replyId);
	}
	
	
	
	
	
}
