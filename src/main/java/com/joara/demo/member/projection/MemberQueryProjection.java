package com.joara.demo.member.projection;

import java.util.UUID;

public record MemberQueryProjection() {
	public record MemberIdProjection(
			UUID id
	) {}
}
