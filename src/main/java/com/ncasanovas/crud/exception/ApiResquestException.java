package com.ncasanovas.crud.exception;

import java.util.ArrayList;
import java.util.List;

public class ApiResquestException extends RuntimeException {

    private List<String> errors = new ArrayList<>();

    public ApiResquestException(String message) {
        super(message);
    }

    public ApiResquestException(String errorMessage, List<String> errors){
        super(errorMessage);
        this.errors = errors;
    }

    public List<String> getErrors(){
        return errors;
    }


}
