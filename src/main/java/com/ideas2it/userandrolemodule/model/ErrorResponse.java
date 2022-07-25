package com.ideas2it.userandrolemodule.model;

import lombok.Data;

@Data
public class ErrorResponse {

    String errorCode;
    String timestamp;
    String errorMessage;
}
