package com.formypet.jpa.user.dto;

import com.formypet.jpa.user.entity.User;

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
public class UserLoginDto {

	private String userId;
	private String userPassword;
	
	public static UserLoginDto toDto(User entity) {
		return UserLoginDto.builder()
				           .userId(entity.getUserId())
						   .userPassword(entity.getUserPassword())
						   .build();
	}
	
}


