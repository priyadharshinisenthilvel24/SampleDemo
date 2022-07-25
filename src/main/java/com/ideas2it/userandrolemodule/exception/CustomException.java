package com.ideas2it.userandrolemodule.exception;

import com.ideas2it.userandrolemodule.model.ErrorResponse;
import lombok.Data;

@Data
public class CustomException extends RuntimeException{

    private ErrorResponse errorResponse;

    public CustomException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
