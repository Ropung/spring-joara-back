package com.joara.demo.episode.exception;

import com.joara.demo.support.exception.CustomException;
import com.joara.demo.support.exception.ErrorCode;

public class  EpisodeQueryException extends CustomException {
	public EpisodeQueryException() {
		super(EpisodeQueryErrorCode.DEFAULT);
	}
	
	public EpisodeQueryException(String message) {
		super(message);
	}
	
	public EpisodeQueryException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EpisodeQueryException(ErrorCode errorCode) {
		super(errorCode);
	}
	
	public EpisodeQueryException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}
}
