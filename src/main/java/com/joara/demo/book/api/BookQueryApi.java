package com.joara.demo.book.api;

import com.joara.demo.book.exception.BookQueryErrorCode;
import com.joara.demo.book.repository.projection.BookListProjection;
import com.joara.demo.book.service.BookQueryService;
import com.joara.demo.common.type.SearchType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joara.demo.book.api.dto.BookQueryDto.BookReadResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@Log4j2
public class BookQueryApi {
	private final BookQueryService bookQueryService;
	
	// Restful(over) -> initial CRUD
	// vs just Rest한 API
	@GetMapping(path = "/genre/{genreEng}")
	public BookReadResponseDto findAllByGenre(
			@PathVariable String genreEng,
			@PageableDefault(size=12, sort="createdAt", direction = Sort.Direction.DESC)
			Pageable pageable,
			@RequestParam(required = false) String keyword,
			@RequestParam(required = false, defaultValue = "NONE") SearchType searchType) {
		
		pageable = pageable.previousOrFirst();
		
		Page<BookListProjection> bookSearchResult = bookQueryService.searchWithGenreBy(
				genreEng, searchType, keyword, pageable);
		List<BookListProjection> books = bookSearchResult.toList();
		long lastPageNumber = bookSearchResult.getTotalPages();
		
		if (pageable.getPageNumber() >= lastPageNumber) {
			throw BookQueryErrorCode.PAGE_OUT_OF_RANGE.defaultException();
		}
		
		return BookReadResponseDto.builder()
				.books(books)
				.lastPage(lastPageNumber)
				.build();
	}
}
// GET /genre/1/books
// GET /genre/1/books/1
// POST /genre/1/books
// PUT /genre/1/books/Q9ADFDAF
// DELETE /genre/Q9DF7A/books/1
// "/genre/{genreId}/books/{bookId}"

// private ID public CODE(ID)

// GET /books/genre/