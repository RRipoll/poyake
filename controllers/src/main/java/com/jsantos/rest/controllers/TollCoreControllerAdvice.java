package com.jsantos.rest.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;

@ControllerAdvice
//@Priority(Ordered.LOWEST_PRECEDENCE) // Lower values have higher priority.

public class TollCoreControllerAdvice {

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<ApiException> resourceNotFound(EmptyResultDataAccessException ex) {
		ApiException apiException = new ApiException(ApiError.NOT_FOUND, ex);
		fillRequest(apiException);

		//log.error("*** Empty result data exception {}", ex);
		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
		// return new ResponseEntity<>(ApiException, ApiException.getError().getHttpStatus());
	}

	@ExceptionHandler({ NullPointerException.class })
	public ResponseEntity<ApiException> genericException(Exception ex) {
		ApiException apiException = new ApiException(ApiError.NULL_POINTER_EXCEPTION, ex);
		fillRequest(apiException);

		//log.error("*** NullPointer exception {}", ex);

		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
		//return new ResponseEntity<>(ApiException, ApiException.getError().getHttpStatus());
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
  	public ResponseEntity<ApiException> validationException(MethodArgumentNotValidException ex) {
		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append("VALIDATION ERROR: ");
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			if (error instanceof FieldError) {
				errorMessage.append("FieldName: ").append(((FieldError) error).getField())
				.append(", RejectedValue: ").append(((FieldError) error).getRejectedValue())
				.append(", ErrorMessage: ").append(error.getDefaultMessage())
				.append("; ");
			} else if (error instanceof ObjectError) {
				errorMessage.append("ValidationMessage: ").append(error.getDefaultMessage()).append("; ");
			}
		}
		
		ApiException apiException = new ApiException(ApiError.VALIDATION_ERROR, errorMessage.toString(), ex);
		fillRequest(apiException);

		//log.error("*** Validation exception1 {}", ex);

		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
		//return new ResponseEntity<>(ApiException, ApiException.getError().getHttpStatus());
	}
/*
	@ExceptionHandler({ BindException.class, TypeMismatchException.class, MissingServletRequestParameterException.class, HttpMessageNotReadableException.class })
	public ResponseEntity<ApiException> validationException(Exception ex) {
		ApiException ApiException = new ApiException(ApiError.VALIDATION_ERROR, ex);
		fillRequest(ApiException);
		//log.error("*** Validation exception2 {}", ex);

		return new ResponseEntity<>(ApiException, HttpStatus.BAD_REQUEST);
		//return new ResponseEntity<>(ApiException, ApiException.getError().getHttpStatus());
	}
*/
	@ExceptionHandler({ ApiException.class })
	public ResponseEntity<ApiException> ApiException(ApiException ex) {

		fillRequest(ex);
		//log.error("*** ApiException = {}", ex);

		return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
		//return new ResponseEntity<>(ex, ex.getError().getHttpStatus());
	}

	@ExceptionHandler({ DataAccessException.class })
	public ResponseEntity<ApiException> dataAccessException(Exception ex) {
		ApiException apiException = new ApiException(ApiError.DB_ERROR, ex);
		fillRequest(apiException);
		//log.error("*** Data access exception {}", ex);

		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
		//return new ResponseEntity<>(ApiException, ApiException.getError().getHttpStatus());
	}

	@ExceptionHandler({ Exception.class, RuntimeException.class, Throwable.class })
	public ResponseEntity<ApiException> exception(Exception ex) {
		ApiException apiException = new ApiException(ApiError.UNKNOWN_ERROR, ex);
		
		fillRequest(apiException);
		
		//log.error("*** Generic exception {}", ex);

		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
		//return new ResponseEntity<>(ApiException, ApiException.getError().getHttpStatus());
	}
	
	private void fillRequest(ApiException apiException){
		
			
			apiException.setBody(" \n &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&  \n "+apiException.getBody());
			
	}

}
