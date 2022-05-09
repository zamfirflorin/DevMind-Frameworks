package com.example.curs13springboot;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class HarryPotterService {

    private static final String SEP = " ";
    private Faker faker = new Faker();

    public String getName() {
        return faker.harryPotter().character();
    }
}
