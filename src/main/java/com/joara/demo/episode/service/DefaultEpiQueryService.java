package com.joara.demo.episode.service;

import com.joara.demo.episode.domain.Episode;
import com.joara.demo.episode.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
@Log4j2
public class DefaultEpiQueryService implements EpiQueryService{
	
	private final EpisodeRepository episodeRepository;
	
	@Override
	public Page<Episode> findEpisode(UUID bookId, Pageable pageable) {
		return episodeRepository.findAllByBookId(bookId,pageable);
	}
}
