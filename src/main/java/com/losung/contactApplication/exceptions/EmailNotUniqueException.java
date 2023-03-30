package com.losung.contactApplication.exceptions;

public class EmailNotUniqueException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Email needs to be unique";
    }
}
