package com.formypet.jpa.animal.service;

import java.util.List;

import com.formypet.jpa.animal.entity.Animal;

public interface AnimalService {
	
	//동물등록
	public Animal insert(Animal animal);
	
	//강아지 리스트 최신순
	List<Animal> findByAnimalType_OrderByCreatedTimeDesc(String animaltype);
	
	

}
