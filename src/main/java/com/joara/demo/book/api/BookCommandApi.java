package com.joara.demo.book.api;


import com.joara.demo.book.api.dto.BookCommandDto;
import com.joara.demo.book.service.BookCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public final class BookCommandApi {
	
	private final BookCommandService bookCommandService;
	
	@PostMapping("/add")
	public BookCommandDto.BookAddResponseDto bookAddResponseDto(
			@RequestPart(value = "coverImage", required = false) MultipartFile file,
			@ModelAttribute @Valid BookCommandDto.BookAddRequestDto body,
			HttpServletRequest request){
		return new BookCommandDto.BookAddResponseDto(bookCommandService.add(body, file, request));
	}
}
