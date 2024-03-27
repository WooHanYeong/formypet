package com.formypet.jpa.adopt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.formypet.jpa.adopt.dto.AdoptDto;
import com.formypet.jpa.animal.entity.Animal;
import com.formypet.jpa.user.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "adopt")
@Table(name = "adopt")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adopt {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String adoptPhone;
	
	private String adoptComment;
	
	private String adoptStatus;
	
	
	@CreationTimestamp
	private LocalDateTime createdTime;
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	public static Adopt toEntity(AdoptDto dto) {
		return Adopt.builder()
					.adoptStatus(dto.getAdoptStatus())
					.adoptComment(dto.getAdoptComment())
					.build();
	}
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "animal_id")
	@ToString.Exclude
	private Animal animal;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;
	
}
