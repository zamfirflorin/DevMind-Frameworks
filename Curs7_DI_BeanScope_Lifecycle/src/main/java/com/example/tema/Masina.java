package com.example.tema;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Masina implements Automobil{

    private int maxDrivingSpeed;
    @Override
    public void travel() {

    }
}
