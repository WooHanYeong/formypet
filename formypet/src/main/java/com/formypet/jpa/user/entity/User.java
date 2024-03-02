package com.formypet.jpa.user.entity;

import java.io.Serializable;

import com.formypet.jpa.user.dto.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "userinfo")
@Table(name = "userinfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable{

	@Id
	private Long id;
	private String name;
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
}
