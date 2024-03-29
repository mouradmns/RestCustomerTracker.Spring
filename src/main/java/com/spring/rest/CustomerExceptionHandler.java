package com.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {


    //add exception handler for notfound Exception:

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handlerException(CustomerNotFoundException exc){
         CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
                                                                    exc.getMessage(),
                                                                    System.currentTimeMillis());

         return new  ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handlerException(Exception exc){
        CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        return new  ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    //add exception handler to catch any Exception:


}
