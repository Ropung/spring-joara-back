package com.joara.demo.episode.api;


import com.joara.demo.episode.service.EpiCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.joara.demo.episode.api.dto.EpiCommandDto.EpiAddRequestDto;
import static com.joara.demo.episode.api.dto.EpiCommandDto.EpiAddResponsetDto;
@RestController
@RequiredArgsConstructor
@RequestMapping("/episode")
public class EpiCommandApi {
	
	private final EpiCommandService epiCommandService;
	@PostMapping("/add")
	public EpiAddResponsetDto add(@Valid EpiAddRequestDto dto, HttpServletRequest request){
		return epiCommandService.add(dto, request);
	}
}
