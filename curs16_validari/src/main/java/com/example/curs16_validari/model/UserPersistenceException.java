package com.example.curs16_validari.model;

public class UserPersistenceException extends RuntimeException{

    public UserPersistenceException(Long userId) {
        super(String.format("Unable to persist user with id '%s", userId));
    }

}
