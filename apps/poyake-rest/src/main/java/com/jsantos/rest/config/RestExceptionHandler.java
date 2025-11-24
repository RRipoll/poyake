package com.jsantos.rest.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsantos.common.util.ListValues;
import com.jsantos.orm.exceptions.ConstraintsException;



@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
   @ExceptionHandler(ConstraintsException.class)
   protected ResponseEntity<ListValues> handleEntityNotFound(
		   ConstraintsException ex) {
       return new ResponseEntity<ListValues>(ex.getErrors(),HttpStatus.BAD_REQUEST);
   }
 }
