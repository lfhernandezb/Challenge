/**
 * 
 */
package com.example.challenge;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.example.challenge.entities.ErrorResponse;

/**
 * @author lfhernandez
 *
 */

@ControllerAdvice
public class RestErrorHandler {
	
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object processInternalServerError(Exception ex) {
    	ErrorResponse response = new ErrorResponse("Please enter a digit");
    	
        return response;
    }
    
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Object processNotFoundError(Exception ex) {
    	ErrorResponse response = new ErrorResponse("Character not exists");
    	
        return response;
    }
    
}
