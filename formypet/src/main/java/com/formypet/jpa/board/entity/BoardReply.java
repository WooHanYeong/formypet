package com.formypet.jpa.board.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.formypet.jpa.board.dto.BoardReplyDto;
import com.formypet.jpa.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardReply {
	@Id
	@SequenceGenerator(name = "BOARDREPLY_BOARDREPLY_NO_SEQ",sequenceName = "BOARDREPLY_BOARDREPLY_NO_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long replyId;
	private String replyContent;
	
	@CreationTimestamp
	private LocalDateTime createdTime;
	
	public static BoardReply toEntity(BoardReplyDto dto) {
		BoardReply boardReply = BoardReply.builder()
											.replyId(dto.getReplyId())
											.replyContent(dto.getReplyContent())
											.board(Board.builder().boardId(dto.getBoardId()).build())
											.user(User.builder().id(dto.getUserId()).build())
											.build();
		return boardReply;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="board_id") // 외래 키 컬럼명 지정
	@ToString.Exclude
	private Board board;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id") // 외래 키 컬럼명 지정
	@ToString.Exclude
	private User user;
	
	
	
	
}
