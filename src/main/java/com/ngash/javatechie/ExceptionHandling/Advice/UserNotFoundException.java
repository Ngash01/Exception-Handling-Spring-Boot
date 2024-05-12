package com.ngash.javatechie.ExceptionHandling.Advice;

public class UserNotFoundException extends Throwable {

    public UserNotFoundException(String message) {
        super(message);
    }
}
