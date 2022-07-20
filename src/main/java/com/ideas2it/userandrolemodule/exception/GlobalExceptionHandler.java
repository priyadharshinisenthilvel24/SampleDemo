package com.ideas2it.userandrolemodule.exception;

import com.ideas2it.userandrolemodule.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private String timeStamp = String.valueOf(Instant.now());

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> noElementFound(NoSuchElementException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(timeStamp);
        errorResponse.setErrorCode(400);
        errorResponse.setErrorMessage("UserID not Found");
        errorResponse.setErrorDetails(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> invalidField(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(timeStamp);
        errorResponse.setErrorCode(400);
        errorResponse.setErrorMessage("Mandatory fields are missing");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> invalidTypeError(IllegalArgumentException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(timeStamp);
        errorResponse.setErrorCode(400);
        errorResponse.setErrorMessage("Invalid Data");
        errorResponse.setErrorDetails(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
