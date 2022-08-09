package com.app.Exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(StudentException se, WebRequest wr)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimestamp(LocalDate.now());
		myErrorDetails.setMessage(se.getMessage());
		myErrorDetails.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception e, WebRequest wr)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setTimestamp(LocalDate.now());
		myErrorDetails.setMessage(e.getMessage());
		myErrorDetails.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(NoHandlerFoundException se, WebRequest wr)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDate.now(),se.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(MethodArgumentNotValidException se, WebRequest wr)
	{
		MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDate.now(),"Validation Error",wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
}
