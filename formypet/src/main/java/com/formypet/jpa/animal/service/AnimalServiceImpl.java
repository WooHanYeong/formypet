package com.formypet.jpa.animal.service;

import java.util.List;
import java.util.Optional;

import com.formypet.jpa.animal.entity.Animal;

public class AnimalServiceImpl implements AnimalService{

	@Override
	public Animal insert(Animal animal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Animal> findByAnimalType_OrderByCreatedTimeDesc(String animaltype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Animal> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

}
