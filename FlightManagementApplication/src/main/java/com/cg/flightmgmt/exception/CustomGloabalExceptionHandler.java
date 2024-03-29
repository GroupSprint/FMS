package com.cg.flightmgmt.exception;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGloabalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
        Map<String, Object> body = new LinkedHashMap<String, Object>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
	}
	
	@ExceptionHandler(ConstraintViolationException.class) 
	public void  springHandleNotFound(HttpServletResponse response) throws IOException{
	  response.sendError(HttpStatus.BAD_REQUEST.value(),"Constraint issues"); 
	}
 
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public void  springMethodArgHandleIssue(HttpServletResponse response) throws IOException{
		  response.sendError(HttpStatus.BAD_REQUEST.value(), "Arguments mismatched......"); 
	}
	
	@ExceptionHandler(BookingNotFoundException.class) 
	public void  springHandleNotFound1(HttpServletResponse response) throws IOException{
	  response.sendError(HttpStatus.NOT_FOUND.value(), "Booking Not Found......");
	}
	
	@ExceptionHandler(FlightNotFoundException.class) 
	public void  springHandleNotFound2(HttpServletResponse response) throws IOException{
	  response.sendError(HttpStatus.NOT_FOUND.value(), "Flight not Found......");
	}

	@ExceptionHandler(UserNotFoundException.class) 
	public void  springHandleNotFound3(HttpServletResponse response) throws IOException{
	  response.sendError(HttpStatus.NOT_FOUND.value(), "User not Found......");
	}
}

