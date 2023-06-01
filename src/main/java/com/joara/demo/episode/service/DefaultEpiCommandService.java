package com.joara.demo.episode.service;


import com.joara.demo.book.repository.BookRepository;
import com.joara.demo.book.repository.projection.BookCoverUrlProjection;
import com.joara.demo.episode.domain.Episode;
import com.joara.demo.episode.domain.type.EpisodeStatus;
import com.joara.demo.episode.repository.EpisodeRepository;
import com.joara.demo.member.repository.MemberRepository;
import com.joara.demo.util.jwt.JwtPayloadParser;
import com.joara.demo.util.jwt.JwtPayloadParserBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

import static com.joara.demo.episode.api.dto.EpiCommandDto.EpiAddRequestDto;
import static com.joara.demo.episode.api.dto.EpiCommandDto.EpiAddResponsetDto;

@Service
@RequiredArgsConstructor
@Log4j2
public class DefaultEpiCommandService implements EpiCommandService{
	
	private final JwtPayloadParserBuilder jwtPayloadParserBuilder;
	private final MemberRepository memberRepository;
	private final EpisodeRepository episodeRepository;
	private final BookRepository bookRepository;
	
	@Override
	public EpiAddResponsetDto add(EpiAddRequestDto dto, HttpServletRequest request) {
		
		
		JwtPayloadParser payloadParser = jwtPayloadParserBuilder.buildWith(request);
		
		String email = payloadParser.subject();
		String nickname = payloadParser.claims().get("nickname", String.class);
		
		// 유저 아이디
		UUID memberId = memberRepository.findIdByEmail(email)
				.orElseThrow(IllegalStateException::new)
				.id();
		
		// 책 커버
		Optional<BookCoverUrlProjection> optionalCoverUrl = bookRepository.findCoverUrlById(dto.bookId());
		
		String coverUrl = optionalCoverUrl.isPresent() ?
				optionalCoverUrl.get().coverUrl()
				: "";
		
		Episode episode = Episode.builder()
				.bookId(dto.bookId())
				.memberId(memberId)
				.nickname(nickname)
				.title(dto.title())
				.content(dto.content())
				.review(dto.review())
				.coverUrl(coverUrl)
				.viewCount(0)
				.status(EpisodeStatus.UPLOADED)
				.build();
		episodeRepository.save(episode);
		
		return EpiAddResponsetDto.builder()
				.success(true)
				.build();
	}
	

}
