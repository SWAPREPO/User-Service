package com.sst.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -3851516239889001002L;
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
