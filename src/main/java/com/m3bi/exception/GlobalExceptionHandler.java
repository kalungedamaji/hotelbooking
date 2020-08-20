package com.m3bi.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.m3bi.model.ExceptionResponse;

//@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({UserNotFoundException.class})
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ExceptionResponse handleResouceNotFound(final UserNotFoundException exception,
															final HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.setRequestedURI(request.getRequestURI());
		return response;
	}
	
	@ExceptionHandler({HotelNotFoundException.class})
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ExceptionResponse handleHotelNotFound(final HotelNotFoundException exception,
															final HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.setRequestedURI(request.getRequestURI());
		return response;
	}
	
	@ExceptionHandler({RoomTypeNotFoundException.class})
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ExceptionResponse handleRoomTypeNotFound(final RoomTypeNotFoundException exception,
															final HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.setRequestedURI(request.getRequestURI());
		return response;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleException(final Exception exception,
											final HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.setRequestedURI(request.getRequestURI());
		return response;
	}
}