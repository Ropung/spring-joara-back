package com.joara.demo.upload.service;

import org.springframework.web.multipart.MultipartFile;

import static com.joara.demo.upload.api.dto.UploadImageDto.UploadImageResponseDto;

public interface UploadImageService {
	UploadImageResponseDto upload(MultipartFile file);
}
