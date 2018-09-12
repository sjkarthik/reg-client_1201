package org.mosip.kernel.uingenerator.exceptionhandler;

import java.util.Date;

import org.mosip.kernel.uingenerator.exception.UinNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class UinControllerAdvice {

	@ExceptionHandler(UinNotFoundException.class)
	@ResponseStatus(code = HttpStatus.ACCEPTED, value = HttpStatus.ACCEPTED)
	public ErrorDetails idTypeNotFound(UinNotFoundException ex, WebRequest req) {
		return new ErrorDetails(new Date(), ex.getMessage(), req.getDescription(false));
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
