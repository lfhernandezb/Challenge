/**
 * 
 */
package com.example.challenge;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import com.example.challenge.exceptions.InvalidInputException;
import com.example.challenge.exceptions.NotFoundException;

/**
 * @author lfhernandez
 *
 */

@ControllerAdvice
public class RestErrorHandler {
	/*
    //@ExceptionHandler(HttpServerErrorException.InternalServerError.class)
	@ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object processInternalServerError(InvalidInputException ex) {
    	ErrorResponse response = new ErrorResponse(ex.getErrorMessage());
    	
        return response;
    }
    
    //@ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Object processNotFoundError(NotFoundException ex) {
    	ErrorResponse response = new ErrorResponse(ex.getErrorMessage());
    	
        return response;
    }
    */
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
    		InvalidInputException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        //body.put("timestamp", LocalDateTime.now());
        body.put("error", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
    		NotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        //body.put("timestamp", LocalDateTime.now());
        body.put("error", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
  
}
