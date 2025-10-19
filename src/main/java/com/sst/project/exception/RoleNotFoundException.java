package com.sst.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends Exception {

	private static final long serialVersionUID = -8104817528073248492L;

	public RoleNotFoundException(String message) {
		super(message);
	}
}
