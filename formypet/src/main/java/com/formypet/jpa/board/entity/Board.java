package com.formypet.jpa.board.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.user.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Board {
	
	@Id
	@SequenceGenerator(name = "BOARD_BOARD_NO_SEQ",sequenceName = "BOARD_BOARD_NO_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BOARD_BOARD_NO_SEQ")
	private Long boardId;
	private String boardTitle;
	@Column(columnDefinition = "CLOB")
	private String boardContent;
	private String boardImage;
	private int boardReadCount; 
	private int boardRecommend;
	
	@CreationTimestamp
	private LocalDateTime createdTime;
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	
	public static Board toEntity(BoardDto dto) {
		Board board= Board.builder()
					.boardTitle(dto.getBoardTitle())
					.boardContent(dto.getBoardContent())
					.boardImage(dto.getBoardImage())
					.boardReadCount(dto.getBoardReadCount())
					.boardRecommend(dto.getBoardRecommend())
					.boardCategory(BoardCategory.builder().categoryId(dto.getBoardCategoryId()).build())
					.boardSubCategory(BoardSubCategory.builder().subCategoryId(dto.getBoardSubCategoryId()).build())
					.build();
		return board;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	@ToString.Exclude
	private BoardCategory boardCategory;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sub_category_id")
	@ToString.Exclude
	private BoardSubCategory boardSubCategory;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	@Builder.Default
	@ToString.Exclude
	private List<BoardReply> boardReply = new ArrayList<>();


	

	
}
