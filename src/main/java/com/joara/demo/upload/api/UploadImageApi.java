package com.joara.demo.upload.api;

import com.joara.demo.common.properties.upload.UploadImageProperties;
import com.joara.demo.upload.service.UploadImageService;
import com.joara.demo.util.upload.DailyFileNameGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.joara.demo.upload.api.dto.UploadImageDto.UploadImageRequestDto;
import static com.joara.demo.upload.api.dto.UploadImageDto.UploadImageResponseDto;

@RestController
@RequestMapping("/upload")
@Log4j2
public class UploadImageApi {
	
	private final UploadImageService uploadImageService;
	
	public UploadImageApi(
			UploadImageProperties uploadImageProperties,
			UploadImageService s3UploadImageService,
			UploadImageService localUploadImageService,
			DailyFileNameGenerator dailyFileNameGenerator
			) {
		this.uploadImageService = switch (uploadImageProperties.target()){
			case S3 -> s3UploadImageService;
			case LOCAL -> localUploadImageService;
			default -> throw new Error("안 만들었음.");
		};
	}
	
	@PostMapping("/image")
	public UploadImageResponseDto uploadImage(UploadImageRequestDto params){
		UploadImageResponseDto result =  uploadImageService.upload(params.file());
		return new UploadImageResponseDto(result.url());
	}
	
}
