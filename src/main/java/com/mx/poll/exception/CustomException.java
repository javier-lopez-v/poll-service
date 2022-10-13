package com.mx.poll.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomException {

	private final String message;
	private final HttpStatus status;
	private final String level;

	public CustomException(String message, HttpStatus status, String level) {
		this.message = message;
		this.status = status;
		this.level = level;

	}
}
