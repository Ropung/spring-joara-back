package com.joara.demo.episode.repository;

import com.joara.demo.episode.domain.Episode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EpisodeRepository  extends JpaRepository<Episode, UUID> {
	Page<Episode> findAllByBookId(UUID bookId, Pageable pageable);
}
