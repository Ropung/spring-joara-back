package com.joara.demo.episode.service;

import javax.servlet.http.HttpServletRequest;

import static com.joara.demo.episode.api.dto.EpiCommandDto.EpiAddRequestDto;
import static com.joara.demo.episode.api.dto.EpiCommandDto.EpiAddResponsetDto;

public interface EpiCommandService {
	
	EpiAddResponsetDto add(EpiAddRequestDto body,HttpServletRequest request);
}
