package com.pms.vital.details.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VitalDetailsGlobalExceptionHandler {
	
	@ExceptionHandler(VitalDetailsException.class)
	public ExceptionObject vitalDetailsExceptionHandler(VitalDetailsException ex)
	{
		return new ExceptionObject(LocalDateTime.now(), ex.getMessage(), ErrorConstant.ADMIN_CONTACT, ex.getStackTrace()[0], false);
	}
	
	@ExceptionHandler(Exception.class)
	public ExceptionObject vitalDetailsExceptionHandler(Exception ex)
	{
		return new ExceptionObject(LocalDateTime.now(), ex.getMessage(), ErrorConstant.ADMIN_CONTACT, ex.getStackTrace()[0], false);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ExceptionObject vitalDetailsExceptionHandler(RuntimeException ex)
	{
		return new ExceptionObject(LocalDateTime.now(), ex.getMessage(), ErrorConstant.ADMIN_CONTACT, ex.getStackTrace()[0], false); 
	}

}
