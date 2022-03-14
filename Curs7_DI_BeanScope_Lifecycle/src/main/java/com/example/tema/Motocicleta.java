package com.example.tema;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Motocicleta implements Automobil{

    private int maxDrivingSpeed;
    @Override
    public void travel() {

    }
}
