package com.example.curs16_validari.exceptions;

public class UserPersistenceException extends RuntimeException{

    public UserPersistenceException(String email) {
        super(String.format("User with email already exists '%s", email));
    }

}
