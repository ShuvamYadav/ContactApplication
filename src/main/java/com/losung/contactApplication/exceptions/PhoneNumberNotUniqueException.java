package com.losung.contactApplication.exceptions;

public class PhoneNumberNotUniqueException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Phone number needs to be unique";
    }
}
