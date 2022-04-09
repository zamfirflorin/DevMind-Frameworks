package com.example.curs16_validari.controller;

import com.example.curs16_validari.model.User;
import com.example.curs16_validari.model.UserPersistenceException;
import com.example.curs16_validari.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User handleRegister(@RequestBody User user) {
        return userService.save(user);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserPersistenceException.class)
    public String handleUserPersistenceException(UserPersistenceException ex) {
        return ex.getMessage();
    }

    @PostMapping("/login")
    public void login(@RequestBody EmailAndPasswordDto emailAndPasswordDto) {
        userService.authenticate(emailAndPasswordDto.getEmail(), emailAndPasswordDto.getPassword());
    }

}