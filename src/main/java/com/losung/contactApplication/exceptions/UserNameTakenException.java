package com.losung.contactApplication.exceptions;

public class UserNameTakenException extends RuntimeException {

    @Override
    public String getMessage() {
        return "UserName already taken";
    }
}
