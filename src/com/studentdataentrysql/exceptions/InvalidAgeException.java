package com.studentdataentrysql.exceptions;


public class InvalidAgeException extends RuntimeException {

    public InvalidAgeException(String message) {
        super(message);
    }
}
