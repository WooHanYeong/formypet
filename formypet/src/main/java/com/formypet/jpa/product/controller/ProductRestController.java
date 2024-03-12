/*
 * package com.formypet.jpa.product.controller;
 * 
 * import java.io.File; import java.io.IOException; import
 * java.time.LocalDateTime; import java.time.temporal.ChronoField;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * import com.formypet.jpa.product.dto.ImageDto; import
 * com.formypet.jpa.product.dto.ProductDto; import
 * com.formypet.jpa.product.entity.Product; import
 * com.formypet.jpa.product.service.ProductServiceImpl; import
 * com.formypet.jpa.product.service.TestService;
 * 
 * import io.swagger.v3.oas.annotations.Operation;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/product") public class ProductRestController {
 * 
 * @Autowired private ProductServiceImpl productServiceImpl;
 * 
 * @Autowired private TestService testService;
 * 
 * @Operation(summary = "상품 및 이미지 등록")
 * 
 * @PostMapping("/create_with_image") public ResponseEntity<ProductDto>
 * createProductWithImage(@RequestParam(name = "image") MultipartFile image,
 * 
 * @RequestParam(name = "productName") String productName,
 * 
 * @RequestParam(name = "productContent") String productContent) { try { // 이미지
 * 업로드 및 이미지 정보 저장 ImageDto imgDto = saveImage(image);
 * 
 * // 상품 등록 ProductDto productDto = new ProductDto();
 * productDto.setProductName(productName);
 * productDto.setProductContent(productContent);
 * productDto.setImage(imgDto.getImageId()); // 상품 DTO에 이미지 정보 추가
 * 
 * Product product = productServiceImpl.insert(productDto.toEntity());
 * ProductDto createProductDto = ProductDto.toDto(product); return new
 * ResponseEntity<>(createProductDto, HttpStatus.CREATED);
 * 
 * } catch (Exception e) { e.printStackTrace(); return new
 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
 * 
 * private ImageDto saveImage(MultipartFile image) throws IOException { // 이미지
 * 저장 로직을 이곳에 작성하고 이미지 정보를 반환 // 이미지 저장 후 ImageDto 반환 LocalDateTime now =
 * LocalDateTime.now(); int year = now.getYear(); int month =
 * now.getMonthValue(); int day = now.getDayOfMonth(); int hour = now.getHour();
 * int minute = now.getMinute(); int second = now.getSecond(); int millis =
 * now.get(ChronoField.MILLI_OF_SECOND);
 * 
 * String absolutePath = new File("src/main/resources/static").getAbsolutePath()
 * + "/"; String newFileName = "image" + hour + minute + second + millis; // 새로
 * 부여한 이미지명 String fileExtension = '.' +
 * image.getOriginalFilename().replaceAll("^.*\\.(.*)$", "$1"); // 정규식 이용하여 확장자만
 * 추출 String path = "/productimg/" + year + "/" + month + "/" + day;
 * 
 * try { if (!image.isEmpty()) { File file = new File(absolutePath + path); if
 * (!file.exists()) { file.mkdirs(); // mkdir()과 다르게 상위 폴더가 없을 때 상위폴더까지 생성 }
 * 
 * file = new File(absolutePath + path + "/" + newFileName + fileExtension);
 * image.transferTo(file);
 * 
 * return ImageDto.builder() .originImageName(image.getOriginalFilename())
 * .imagePath(path) .imageName(newFileName + fileExtension) .build(); } } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * return null; } }
 * 
 */