package com.example.curs16_validari.db;

import com.example.curs16_validari.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Component
public class InMemoryDatabase {

    Map<String, User> userTable = new HashMap<>();

}
