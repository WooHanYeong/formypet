package com.formypet.jpa.animal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formypet.jpa.animal.entity.Animal;
import com.formypet.jpa.animal.repository.AnimalRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	private AnimalRepository animalRepository;
	
	//동물등록
	@Override
	public Animal insert(Animal animal) {
		return animalRepository.save(animal);
	}
	
	//동물 리스트 최신순(list)
	@Override
	public List<Animal> findByAnimalType_OrderByCreatedTimeDesc(String animaltype) {
		return animalRepository.findByAnimalType_OrderByCreatedTimeDesc(animaltype);
	}
	
	//아이디로 동물찾기(detail)
	@Override
	public Optional<Animal> findById(Long id) {
		return animalRepository.findById(id);
	}
	
	//동물삭제
	@Override
	public void deleteAllById(Iterable<Long> ids) {
		animalRepository.deleteAllById(ids);
	}
	
	//전체리스트
	@Override
	public List<Animal> findAllAnimalList() {
		return animalRepository.findAll();
	}
	

}
