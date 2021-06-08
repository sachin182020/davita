package com.pms.vital.details.exception;

import java.time.LocalDateTime;

public class ExceptionObject {

	private  LocalDateTime timeStamp;
	private  String message;
	private  String error;
	private  StackTraceElement stacktrace;
	private boolean successFlag;
	
	
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getError() {
		return error;
	}



	public void setError(String error) {
		this.error = error;
	}



	public StackTraceElement getStacktrace() {
		return stacktrace;
	}



	public void setStacktrace(StackTraceElement stacktrace) {
		this.stacktrace = stacktrace;
	}



	public boolean isSuccessFlag() {
		return successFlag;
	}



	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}



	public ExceptionObject(LocalDateTime now, String message2, String adminContact, StackTraceElement stackTraceElement, boolean b) 
	{
		this.timeStamp = now;
		this.message = message2;
		this.error = adminContact;
		this.stacktrace = stackTraceElement;
		this.successFlag = b;
	}

}
