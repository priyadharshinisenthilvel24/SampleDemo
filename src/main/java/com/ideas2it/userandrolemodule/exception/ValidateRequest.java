package com.ideas2it.userandrolemodule.exception;

import com.ideas2it.userandrolemodule.model.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ValidateRequest {

    @Autowired
    GlobalExceptionHandler globalExceptionHandler;

    private String timeStamp = String.valueOf(Instant.now());

    public void invalidUserName(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(timeStamp);
        errorResponse.setErrorCode("U1002");
        errorResponse.setErrorMessage("UserName is blank/invalid");
        throw new CustomException(errorResponse);
    }

    public void userNameNotFound(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(timeStamp);
        errorResponse.setErrorCode("U1003");
        errorResponse.setErrorMessage("UserName not Found");
        throw new CustomException(errorResponse);
    }

    public void roleNotfound(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(timeStamp);
        errorResponse.setErrorCode("U1005");
        errorResponse.setErrorMessage("Role is missing");
        throw new CustomException(errorResponse);
    }

    public void invalidRole(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(timeStamp);
        errorResponse.setErrorCode("U1005");
        errorResponse.setErrorMessage("Role is not valid");
        throw new CustomException(errorResponse);
    }

    public void invalidRequest(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(timeStamp);
        errorResponse.setErrorCode("U1005");
        errorResponse.setErrorMessage("Invalid Request");
        throw new CustomException(errorResponse);
    }

}
