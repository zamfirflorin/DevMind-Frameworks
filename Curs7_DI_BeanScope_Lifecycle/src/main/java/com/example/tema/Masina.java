package com.example.tema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Masina implements Automobil{

    Motor motor;

    public Masina(Motor motor) {
        this.motor = motor;
    }

    @Override
    public void travel() {
        System.out.println("Rolling in my car...");
    }

    @Override
    public int maxDrivingSpeed() {
        return 240;
    }
}
