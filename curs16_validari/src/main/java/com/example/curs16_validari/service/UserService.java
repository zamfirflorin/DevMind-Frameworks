package com.example.curs16_validari.service;

import com.example.curs16_validari.model.User;
import com.example.curs16_validari.model.UserPersistenceException;
import com.example.curs16_validari.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {

        String email = user.getEmail();
        boolean emailsExists = userRepository.getInMemoryDatabase().getUserTable().containsKey(email);
        if (emailsExists) throw new UserPersistenceException(user.getId());
        return userRepository.getInMemoryDatabase().getUserTable().put(email, user);
    }

    public boolean authenticate(String email, String Password) {
        if (Boolean.FALSE == match(email, Password)) {
            throw new UserAuthenticationException("Wrong username or password");
        }
        return true;
    }

    public boolean match(String email, String password) {
        var table = userRepository.getInMemoryDatabase().getUserTable();
        var peristedUser = table.get(email);
        var peristedUserPassword = peristedUser.getPassword();
        return password.equals(peristedUserPassword);
    }
}
