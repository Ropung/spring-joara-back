package com.joara.demo.support;

import java.time.ZoneId;

public final class Constants {
	public static final String BASE_PACKAGE = "com.joara.demo";
	public static final String DEFAULT_TIMEZONE_NAME = "Asia/Seoul";
	public static final ZoneId DEFAULT_TIMEZONE_ID = ZoneId.of(DEFAULT_TIMEZONE_NAME);
	
	private Constants(){}
}