package com.ncasanovas.crud.exception;

import java.util.List;

public class RequestSystemException extends ApiResquestException {
    public RequestSystemException(String message) {
        super(message);
    }

    public RequestSystemException(String msg, List<String> errors) {
        super(msg, errors);
    }
}
