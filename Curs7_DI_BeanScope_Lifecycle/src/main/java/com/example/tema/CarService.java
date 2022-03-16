package com.example.tema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CarService {

    @Autowired
    @Qualifier("masina")
    private Automobil automobil;

    private Autocar autocar;

    private Motocicleta motocicleta;

    public void travel() {
        automobil.travel();
    }



}
