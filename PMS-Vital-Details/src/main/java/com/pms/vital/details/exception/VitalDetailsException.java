package com.pms.vital.details.exception;

public class VitalDetailsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public VitalDetailsException(String message)
	{
		super(message);
	}
	
	public VitalDetailsException() {}
}
