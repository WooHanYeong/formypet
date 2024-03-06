package com.formypet.jpa.user.entity;

import com.formypet.jpa.user.dto.UserDto;
import com.formypet.jpa.user.dto.UserLoginDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "userentity")
@Table(name = "userentity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String userId;
    
    private String userPassword;

    private String userName;

    private String userAddress;
    
    private String userBirthDate;
    
    
    public static User toEntity(UserLoginDto dto) {
        return User.builder()
                         .userId(dto.getUserId())
                         .userPassword(dto.getUserPassword())
                         .build();
    }
    
    public static User toEntity(UserDto dto) {
    	return User.builder()
    					 .userId(dto.getUserId())
    					 .userPassword(dto.getUserPassword())
    					 .userName(dto.getUserName())
    					 .userAddress(dto.getUserAddress())
    					 .userBirthDate(dto.getUserBirthDate())
    					 .build();
    
    }
    
 }
   
