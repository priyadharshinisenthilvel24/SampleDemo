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

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> customException(CustomException e){
        return new ResponseEntity<ErrorResponse>(e.getErrorResponse(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> noElementFound(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(timeStamp);
        errorResponse.setErrorCode("U1001");
        errorResponse.setErrorMessage("UserID not Found");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> invalidField(CustomException e){
        return new ResponseEntity<ErrorResponse>(e.getErrorResponse(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> invalidTypeError(IllegalArgumentException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(timeStamp);
        errorResponse.setErrorCode("U1006");
        errorResponse.setErrorMessage("Invalid Request");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
