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
public class UserDto {
	
	private String userId;
	
	private String userPassword;
	
    private String userName;

    private String userAddress;
    
    private String userAddressDetail;
    
    private String userBirthDate;
    
    public static UserDto toDto(User entity) {
    	return UserDto.builder()
    				  .userId(entity.getUserId())
    				  .userPassword(entity.getUserPassword())
    				  .userName(entity.getUserName())
    				  .userAddress(entity.getUserAddress())
    				  .userAddressDetail(entity.getUserAddressDetail())
    				  .userBirthDate(entity.getUserBirthDate())
    				  .build();
    }
}
