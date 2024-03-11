
package com.formypet.jpa.product.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.formypet.jpa.product.dto.ImageDto;
import com.formypet.jpa.product.service.TestService;

@RestController
public class ImageUpload {

	@Autowired
	private TestService testService;
	
	@PostMapping("/image/V1/api")
	public String imageUploadV1(@RequestParam(name = "image") MultipartFile image) throws IOException {

	    // 폴더 생성과 파일명 새로 부여를 위한 현재 시간 알아내기
	    LocalDateTime now = LocalDateTime.now();
	    int year = now.getYear();
	    int month = now.getMonthValue();
	    int day = now.getDayOfMonth();
	    int hour = now.getHour();
	    int minute = now.getMinute();
	    int second = now.getSecond();
	    int millis = now.get(ChronoField.MILLI_OF_SECOND);

	    String absolutePath = new File("src/main/resources/static").getAbsolutePath() + "/";
	    String newFileName = "image" + hour + minute + second + millis; // 새로 부여한 이미지명
	    String fileExtension = '.' + image.getOriginalFilename().replaceAll("^.*\\.(.*)$", "$1"); // 정규식 이용하여 확장자만 추출
	    String path = "/productimg/" + year + "/" + month + "/" + day;

	    try {
	        if(!image.isEmpty()) {
	            File file = new File(absolutePath + path);
	            if(!file.exists()){
	                file.mkdirs(); // mkdir()과 다르게 상위 폴더가 없을 때 상위폴더까지 생성
	            }

	            file = new File(absolutePath + path + "/" + newFileName + fileExtension);
	            image.transferTo(file);

	            ImageDto imgDto = ImageDto.builder()
	                    .originImageName(image.getOriginalFilename())
	                    .imagePath(path)
	                    .imageName(newFileName + fileExtension)
	                    .build();

	            testService.saveImage(imgDto);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "test/imageV1";
	}
}