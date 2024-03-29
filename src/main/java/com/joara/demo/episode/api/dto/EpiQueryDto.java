package com.joara.demo.episode.api.dto;

import com.joara.demo.episode.domain.Episode;
import lombok.Builder;

import java.util.List;

public record EpiQueryDto() {
	public record EpiQueryRequsetDto() {}
	@Builder
	public record EpiQueryResponsetDto(
			List<Episode> episodes,
			Long lastPage
	){}
}
