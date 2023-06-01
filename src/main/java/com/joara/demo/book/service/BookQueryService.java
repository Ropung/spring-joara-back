package com.joara.demo.book.service;


import com.joara.demo.book.repository.projection.BookListProjection;
import com.joara.demo.common.type.SearchType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookQueryService {
	
	Page<BookListProjection> searchWithGenreBy(String genreEnglishName, SearchType searchType, String keyword, Pageable pageable);
}
