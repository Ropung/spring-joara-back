package com.joara.demo.book.repository.projection;

import lombok.Builder;

@Builder
public record BookCoverUrlProjection(
		String coverUrl
) {}