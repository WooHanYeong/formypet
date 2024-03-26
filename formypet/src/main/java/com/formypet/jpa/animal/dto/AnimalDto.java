package com.formypet.jpa.animal.dto;

import com.formypet.jpa.animal.entity.Animal;

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
public class AnimalDto {
	
	private String animalType;
	private String animalBreed;
	private String animalAge;
	private String animalSex;
	private String animalNeutering;
	private String animalWeight;
	private String animalRegion;
	private String animalEtc;
	private String animalCodeNumber;
	
	public static AnimalDto toDto(Animal entity) {
		return AnimalDto.builder()
						.animalType(entity.getAnimalType())
						.animalBreed(entity.getAnimalBreed())
						.animalAge(entity.getAnimalAge())
						.animalSex(entity.getAnimalSex())
						.animalNeutering(entity.getAnimalNeutering())
						.animalWeight(entity.getAnimalWeight())
						.animalRegion(entity.getAnimalRegion())
						.animalEtc(entity.getAnimalEtc())
						.animalCodeNumber(entity.getAnimalCodeNumber())
						.build();
	}
	
}
