package com.losung.contactApplication.exceptions;

public class IdNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Id not found";
    }
}
