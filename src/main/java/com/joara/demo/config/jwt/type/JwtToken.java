package com.joara.demo.config.jwt.type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class JwtToken {
	
	private String grantType;
	private String accessToken;
	private String refreshToken;
}
