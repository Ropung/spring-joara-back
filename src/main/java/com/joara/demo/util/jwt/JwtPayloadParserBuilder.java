package com.joara.demo.util.jwt;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;

public final class JwtPayloadParserBuilder {
	
	private final JwtParser jwtParser;
	private HttpServletRequest request;
	
	// 외부에서 생성할 수 없게 하고
	private JwtPayloadParserBuilder(JwtParser jwtParser) {
		this.jwtParser = jwtParser;
	}
	
	// 처음엔 무조건 이 스테이틱 메서드들 중에서 선택해서 사용하게 함.
	public static JwtPayloadParserBuilder withJwtParser(JwtParser jwtParser) {
		return new JwtPayloadParserBuilder(jwtParser);
	}
	
	public static JwtPayloadParserBuilder withSecretKey(Key key) {
		return new JwtPayloadParserBuilder(
				Jwts.parserBuilder()
						.setSigningKey(key)
						.build()
		);
	}
	
	// 그 뒤에 쓰는 것들.
	public JwtPayloadParserBuilder httpServletRequest(HttpServletRequest request) {
		this.request = request;
		return this;
	}
	
	public JwtPayloadParser build() {
		return buildWith(this.request);
	}
	
	public JwtPayloadParser buildWith(HttpServletRequest request) {
		if (request == null) throw new IllegalStateException("Http Servlet Request를 채워서 만드쇼.");
		return new JwtPayloadParser(jwtParser, request);
	}
}
