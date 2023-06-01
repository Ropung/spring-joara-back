package com.joara.demo.book.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static com.joara.demo.book.api.dto.BookCommandDto.BookAddRequestDto;

public interface BookCommandService {
	boolean add(BookAddRequestDto dto, MultipartFile file, HttpServletRequest request);
}
