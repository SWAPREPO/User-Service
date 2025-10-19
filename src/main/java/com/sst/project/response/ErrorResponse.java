package com.sst.project.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder
public class ErrorResponse {

	private String errorMessage;
	private String errorDetails;
	private LocalDateTime localDateTime;

	public ErrorResponse(LocalDateTime localDateTime, String errorMessage, String errorDetails) {
		super();
		this.localDateTime = localDateTime;
		this.errorMessage  = errorMessage;
		this.errorDetails  = errorDetails;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
}
