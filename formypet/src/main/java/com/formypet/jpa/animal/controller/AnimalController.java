package com.formypet.jpa.animal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formypet.jpa.animal.entity.Animal;
import com.formypet.jpa.animal.service.AnimalService;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	
	//animalmain index
	@GetMapping("/animal_list_index")
	public String animal_list_index() {
		String forwardPath = "animal_list_index";
		return forwardPath;
	}
	
	//list
	@GetMapping("/animal_list_dog")
	public String animal_list_dog(Model model) {
		List<Animal> animalDogList = animalService.findByAnimalType_OrderByCreatedTimeDesc("강아지");
		model.addAttribute("animalDogList",animalDogList);
		return "animal_list_dog";
	}
	
	@GetMapping("/animal_list_cat")
	public String animal_list_cat(Model model) {
		List<Animal> animalCatList = animalService.findByAnimalType_OrderByCreatedTimeDesc("고양이");
		model.addAttribute("animalCatList",animalCatList);
		return "animal_list_cat";
	}
	
	//detail
	@GetMapping("/animal_detail_dog")
	public String animal_detail_dog() {
		return "animal_detail_dog";
	}
	@GetMapping("/animal_detail_cat")
	public String animal_detail_cat() {
		return "animal_detail_cat";
	}
	
}
