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
	
	@Override
	public Animal insert(Animal animal) {
		return animalRepository.save(animal);
	}

	@Override
	public List<Animal> findByAnimalType_OrderByCreatedTimeDesc(String animaltype) {
		return animalRepository.findByAnimalType_OrderByCreatedTimeDesc(animaltype);
	}

	@Override
	public Optional<Animal> findById(Long id) {
		return animalRepository.findById(id);
	}

	@Override
	public void deleteAllById(Iterable<Long> ids) {
		animalRepository.deleteAllById(ids);
	}

	@Override
	public List<Animal> findAllAnimalList() {
		return animalRepository.findAll();
	}

}
