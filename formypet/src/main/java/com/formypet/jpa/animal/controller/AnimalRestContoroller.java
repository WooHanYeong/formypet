package com.formypet.jpa.animal.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.formypet.jpa.animal.entity.Animal;
import com.formypet.jpa.animal.service.AnimalService;

@RestController
@RequestMapping("/api/animal")
public class AnimalRestContoroller {

	@Autowired
	private AnimalService animalService;

	//유기동물 등록
	@PostMapping("/animalInsertForm")
	public ResponseEntity<String> insertAnimal(@RequestParam("imageFile1") MultipartFile file1,
			@RequestParam("animalType") String animalType, @RequestParam("animalBreed") String animalBreed,
			@RequestParam("animalAge") String animalAge, @RequestParam("animalSex") String animalSex,
			@RequestParam("animalNeutering") String animalNeutering, @RequestParam("animalWeight") String animalWeight,
			@RequestParam("animalRegion") String animalRegion, @RequestParam("animalEtc") String animalEtc,
			@RequestParam("animalCodeNumber") String animalCodeNumber) {

		try {
			// 파일 저장
			String uploadPath1 = System.getProperty("user.dir") + "/src/main/resources/static/animalimg/";
			String originalFileName1 = file1.getOriginalFilename();
			UUID uuid1 = UUID.randomUUID();
			String savedFileName1 = uuid1.toString() + "_" + originalFileName1;
			File newFile1 = new File(uploadPath1 + savedFileName1);
			file1.transferTo(newFile1);
			
			//동물저장
			Animal animal = new Animal(null,animalType,animalBreed,animalAge,animalSex,animalNeutering,animalWeight,animalRegion,animalEtc,animalCodeNumber,savedFileName1, null, null, null);
			animalService.insert(animal);
			
			return ResponseEntity.ok("Animal uploaded successfully.");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload animal.");

		}
	}
	
	//유기동물 삭제(1개이상)
	@DeleteMapping("delete/animals")
	public ResponseEntity<String> deleteAnimals(@RequestBody List<Long> ids){
		animalService.deleteAllById(ids);
	    return ResponseEntity.ok("animals delete successfully.");

	}
	
	
}
