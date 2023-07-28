package com.ncasanovas.crud.exception;

import java.util.List;

public class RequestNotFoundException extends ApiResquestException {
    public RequestNotFoundException(String message) {
        super(message);
    }

    public RequestNotFoundException(String msg, List<String> errors) {
        super(msg, errors);
    }
}
