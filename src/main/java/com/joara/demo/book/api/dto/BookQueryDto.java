package com.joara.demo.book.api.dto;

import com.joara.demo.book.repository.projection.BookListProjection;
import lombok.Builder;

import java.util.List;

public record BookQueryDto() {
	
	public record BookReadRequestDto(
			String keyword
	){
		public BookReadRequestDto {
			if (keyword != null && "".equals(keyword.trim())) keyword = null;
		}
	}
	
	@Builder
	public record BookReadResponseDto(
			List<BookListProjection> books,
			Long lastPage
	){}
}
