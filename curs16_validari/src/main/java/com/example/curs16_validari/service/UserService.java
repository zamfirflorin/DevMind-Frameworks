package com.example.curs16_validari.service;

import com.example.curs16_validari.exceptions.UserAuthenticationException;
import com.example.curs16_validari.exceptions.UserPersistenceException;
import com.example.curs16_validari.model.AuthenticatedUserDto;
import com.example.curs16_validari.model.User;
import com.example.curs16_validari.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        String email = user.getEmail();
        boolean emailsExists = userRepository.getInMemoryDatabase().getUserTable().containsKey(email);
        if (emailsExists) throw new UserPersistenceException(email);
        return userRepository.save(user);
    }

    public AuthenticatedUserDto authenticate(String email, String Password) {
        if (Boolean.FALSE == match(email, Password)) {
            throw new UserAuthenticationException("Invalid username or password");
        }
        User user = userRepository.getInMemoryDatabase().getUserTable().get(email);
        userRepository.authenticate(user);
        AuthenticatedUserDto authenticatedUserDto = new ModelMapper().map(user, AuthenticatedUserDto.class);
        return authenticatedUserDto;
    }

    public boolean isAuthenticated(String email) {
        return userRepository.getInMemoryDatabase().getAuthenticatedUsers().containsKey(email);
    }

    public boolean match(String email, String password) {
        var table = userRepository.getInMemoryDatabase().getUserTable();
        var peristedUser = table.get(email);
        var peristedUserPassword = peristedUser.getPassword();
        return password.equals(peristedUserPassword);
    }

    public AuthenticatedUserDto findAuthenticatedUser(String email) {
        User user = userRepository.getInMemoryDatabase().getAuthenticatedUsers().get(email);
        return new ModelMapper().map(user, AuthenticatedUserDto.class);
    }

    public boolean logout(String email) {
        if (isAuthenticated(email)) {
            userRepository.getInMemoryDatabase().getAuthenticatedUsers().remove(email);
            return true;
        }
        else return false;
    }
}
