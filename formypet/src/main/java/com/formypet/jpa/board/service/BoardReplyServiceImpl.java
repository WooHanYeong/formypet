package com.formypet.jpa.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formypet.jpa.board.dto.BoardReplyDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardReply;
import com.formypet.jpa.board.repository.BoardReplyRepository;
import com.formypet.jpa.board.repository.BoardRepository;
import com.formypet.jpa.user.entity.User;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class BoardReplyServiceImpl implements BoardReplyService{
	@Autowired
	BoardReplyRepository boardReplyRepository;
	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public BoardReply createReply(BoardReplyDto boardReplyDto) {
		BoardReply reply = BoardReply.builder()
										.replyId(boardReplyDto.getReplyId())
										.replyContent(boardReplyDto.getReplyContent())
										.board(Board.builder().boardId(boardReplyDto.getBoardId()).build())
										.user(User.builder().id(boardReplyDto.getUserId()).build())
										.build();
		return boardReplyRepository.save(reply);
	}

	@Override
	public void deleteReply(Long replyId){
		boardReplyRepository.deleteById(replyId);
	}

	@Override
	public List<BoardReply> findReplyByBoardId(Long boardId) throws Exception {
		Optional<Board> optionaBoard = boardRepository.findById(boardId);
		if (optionaBoard.isPresent()) {
			List<BoardReply> reply = optionaBoard.get().getBoardReply();
			return reply;
		}
		throw new Exception("해당 게시글을 찾을 수 없습니다.");
	}

	

}
