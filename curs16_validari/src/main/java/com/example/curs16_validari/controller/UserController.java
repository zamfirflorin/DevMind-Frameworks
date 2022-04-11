package com.example.curs16_validari.controller;

import com.example.curs16_validari.exceptions.UserAuthenticationException;
import com.example.curs16_validari.exceptions.UserPersistenceException;
import com.example.curs16_validari.model.AuthenticatedUserDto;
import com.example.curs16_validari.model.EmailAndPasswordDto;
import com.example.curs16_validari.model.User;
import com.example.curs16_validari.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public User handleRegister(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserPersistenceException.class)
    public String handleUserPersistenceException(UserPersistenceException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAuthenticationException.class)
    public String handleUserAuthenticationException(UserAuthenticationException ex) {
        return ex.getMessage();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticatedUserDto> handleLogin(@Valid @RequestBody EmailAndPasswordDto emailAndPasswordDto) {
        if (userService.isAuthenticated(emailAndPasswordDto.getEmail())) {
            return ResponseEntity.accepted().body(userService.findAuthenticatedUser(emailAndPasswordDto.getEmail()));
        }
        return ResponseEntity.ok(userService.authenticate(emailAndPasswordDto.getEmail(), emailAndPasswordDto.getPassword()));
    }

    @GetMapping("/logout/{email}")
    public ResponseEntity<String> logout(@PathVariable String email) {
        if (userService.logout(email)) {
            return new ResponseEntity<>("User logged out: " + email, HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found: " + email, HttpStatus.NOT_FOUND);
    }

}