package com.formypet.jpa.animal.service;

import java.util.List;
import java.util.Optional;

import com.formypet.jpa.animal.entity.Animal;

public interface AnimalService {
	
	//동물등록
	public Animal insert(Animal animal);
	
	//동물 리스트 최신순
	List<Animal> findByAnimalType_OrderByCreatedTimeDesc(String animaltype);
	
	//아이디로 동물찾기(detail)
	public Optional<Animal> findById(Long id);
	
	//동물삭제
	void deleteAllById(Iterable<Long> ids);
	
	

}
