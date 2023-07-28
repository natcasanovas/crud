package com.ncasanovas.crud.exception;

import java.util.List;

public class RequestValidationException extends ApiResquestException{
    public RequestValidationException(String message) {
        super(message);
    }

    public RequestValidationException(String msg, List<String> errors) {
        super(msg, errors);
    }
}
