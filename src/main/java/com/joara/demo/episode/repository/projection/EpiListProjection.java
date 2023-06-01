package com.joara.demo.episode.repository.projection;

import com.joara.demo.episode.domain.type.EpisodeStatus;

import java.time.OffsetDateTime;
import java.util.UUID;

public record EpiListProjection(
		UUID id,
		UUID memberId,
		String nickname,
		String title,
		Double avgScore,
		String coverUrl,
		Integer viewCount,
		EpisodeStatus status,
		OffsetDateTime createdAt
) {}





