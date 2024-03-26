package com.formypet.jpa.animal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.animal.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

	//강아지 리스트 최신순
	List<Animal> findByAnimalType_OrderByCreatedTimeDesc(String animaltype);
	
	
}
