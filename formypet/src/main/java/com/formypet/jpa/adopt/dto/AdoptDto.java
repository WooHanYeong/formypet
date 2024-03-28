package com.formypet.jpa.adopt.dto;

import com.formypet.jpa.adopt.entity.Adopt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AdoptDto {

	private Long id;
	
	private String adoptStatus;
	
	public static AdoptDto toDto(Adopt entity) {
		return AdoptDto.builder()
					   .id(entity.getId())
					   .adoptStatus(entity.getAdoptStatus())
					   .build();
	}

}
