package com.example.curs16_validari.repository;

import com.example.curs16_validari.db.InMemoryDatabase;
import com.example.curs16_validari.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserRepository {
    @Autowired
    private InMemoryDatabase inMemoryDatabase;

    public User save(User user) {
        return inMemoryDatabase.getUserTable().put(user.getEmail(), user);
    }

    public User authenticate(User user) {
        return inMemoryDatabase.getAuthenticatedUsers().put(user.getEmail(), user);
    }

}
