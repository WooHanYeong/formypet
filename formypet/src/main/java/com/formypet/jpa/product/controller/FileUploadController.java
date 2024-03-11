package com.formypet.jpa.product.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @Autowired
    private Environment env;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        try {
            String uploadPath = env.getProperty("upload.path");
            Path filePath = Paths.get(uploadPath, file.getOriginalFilename());
            Files.write(filePath, file.getBytes());

            // 파일 경로를 모델에 추가하여 뷰로 전달
            model.addAttribute("filePath", filePath.toString());
            return "uploadSuccess"; // 성공 페이지로 리다이렉트
        } catch (IOException e) {
            e.printStackTrace();
            return "uploadError"; // 에러 페이지로 리다이렉트
        }
    }
}

