package com.joara.demo.episode.service;

import com.joara.demo.episode.domain.Episode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EpiQueryService {
	Page<Episode> findEpisode(UUID bookId, Pageable pageable);
}
