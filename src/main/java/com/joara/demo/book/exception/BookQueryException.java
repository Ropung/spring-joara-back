package com.joara.demo.book.exception;


import com.joara.demo.support.exception.CustomException;
import com.joara.demo.support.exception.ErrorCode;

public class BookQueryException extends CustomException {
	public BookQueryException() {
		super(BookQueryErrorCode.DEFAULT);
	}
	
	public BookQueryException(String message) {
		super(message);
	}
	
	public BookQueryException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BookQueryException(ErrorCode errorCode) {
		super(errorCode);
	}
	
	public BookQueryException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}
}
