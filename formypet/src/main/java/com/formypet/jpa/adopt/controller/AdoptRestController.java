package com.formypet.jpa.adopt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.adopt.entity.Adopt;
import com.formypet.jpa.adopt.service.AdoptService;
import com.formypet.jpa.animal.entity.Animal;
import com.formypet.jpa.animal.service.AnimalService;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

@RestController
@RequestMapping("api/adopt")
public class AdoptRestController {

	@Autowired
	private AdoptService adoptService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AnimalService animalService;
	
	//입양등록
	@PostMapping("AdoptIsertForm")
	public ResponseEntity<String> insertAdopt(@RequestParam(value="animalId")Long animalId,
											  @RequestParam(value="userId")Long userId,
											  @RequestParam(value="adoptPhone")String adoptPhone,
											  @RequestParam(value="adoptComment")String adoptComment ){
		try {
			//유저찾기
			User findUser = userService.findUserById(userId);
			System.out.println("findUser -->" + findUser);
			
			//동물찾기
			Animal findAnimal = animalService.findById(animalId).get();
			System.out.println("findAnimal -->" + findAnimal);
			
			if (findUser == null || findAnimal == null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to find user or animal.");
			}
			
			//기본 상태 ="입양대기"로 맞추고 insert등록
			String adoptStatus ="입양대기";
			Adopt newAdopt = new Adopt(null,adoptPhone,adoptComment,adoptStatus,null,null,findAnimal,findUser);
			adoptService.insert(newAdopt);
			
			
			return ResponseEntity.ok("adopt 성공");

		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed adopt.");

		}
	}
	
	//상태수정
	@PostMapping("/ChangeStatus")
	public ResponseEntity<String> ChangeStatus(@RequestBody Long id){
		
		Adopt findAdopt= adoptService.findById(id).get();
		findAdopt.setAdoptStatus("입양완료");
		adoptService.insert(findAdopt);
		
		return ResponseEntity.ok("Products update successfully.");
	}
	
}
