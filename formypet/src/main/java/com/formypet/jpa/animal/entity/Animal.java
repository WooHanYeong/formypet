package com.formypet.jpa.animal.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.formypet.jpa.adopt.entity.Adopt;
import com.formypet.jpa.animal.dto.AnimalDto;

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

@Entity(name = "animal")
@Table(name = "animal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String animalType;
	private String animalBreed;
	private String animalAge;
	private String animalSex;
	private String animalNeutering;
	private String animalWeight;
	private String animalRegion;
	private String animalEtc;
	private String animalCodeNumber;
	private String animalImage;
	
	
	@CreationTimestamp
	private LocalDateTime createdTime;
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	public static Animal toEntity(AnimalDto dto) {
		return Animal.builder()
					 .animalType(dto.getAnimalType())
					 .animalBreed(dto.getAnimalBreed())
					 .animalAge(dto.getAnimalAge())
					 .animalSex(dto.getAnimalSex())
					 .animalNeutering(dto.getAnimalNeutering())
					 .animalWeight(dto.getAnimalWeight())
					 .animalRegion(dto.getAnimalRegion())
					 .animalEtc(dto.getAnimalEtc())
					 .animalCodeNumber(dto.getAnimalCodeNumber())
					 .build();
	}
	
	@OneToOne(mappedBy = "animal", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name="adopt_id")
	private Adopt adopt;
	
	
}
