package com.formypet.jpa.board.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	private Long boardId;
	private String boardTitle;
	private String boardContent;
	private String boardImage;
	private int boardReadCount;
	
}
