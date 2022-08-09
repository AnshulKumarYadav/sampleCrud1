package com.app.Exception;

import java.time.LocalDate;

public class MyErrorDetails {
	
	private LocalDate timestamp;
	private String message;
	private String details;
	
	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public MyErrorDetails(LocalDate timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}
	
	

}
