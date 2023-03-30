package com.losung.contactApplication.exceptions;

public class ContactNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Contact not found. Please check details";
    }
}
