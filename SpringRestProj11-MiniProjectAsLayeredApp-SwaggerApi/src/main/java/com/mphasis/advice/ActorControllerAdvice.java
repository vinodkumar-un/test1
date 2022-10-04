package com.mphasis.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mphasis.exception.ActorNotFoundException;
import com.mphasis.model.ErrorDetails;

//@ControllerAdvice
@RestControllerAdvice
public class ActorControllerAdvice {

	@ExceptionHandler(ActorNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleActorNotFoundException(ActorNotFoundException anfe) {
		System.out.println("ActorControllerAdvice.handleActorNotFoundException()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), "500", anfe.getMessage());
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorDetails> handleAllException(Exception anfe) {
//		System.out.println("ActorControllerAdvice.handleAllException()");
//		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), "500", anfe.getMessage());
//		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
//	}

}
