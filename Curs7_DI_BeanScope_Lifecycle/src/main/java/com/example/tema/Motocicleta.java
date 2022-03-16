package com.example.tema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Motocicleta implements Automobil{

    private Motor motor;

    @Override
    public void travel() {

    }

    @Override
    public int maxDrivingSpeed() {
        return 320;
    }

    @Autowired
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
