package com.ideas2it.userandrolemodule.model;

import lombok.Data;

@Data
public class ErrorResponse {

    int errorCode;
    String timestamp;
    String errorMessage;
    String errorDetails;
}
