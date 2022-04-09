package com.example.tema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Autocar implements Automobil{


    //injectare motor prin field
    @Autowired
    private Motor motor;

    @Override
    public void travel() {
        System.out.println("Calatorind cu autocarul");
    }

    @Override
    public int maxDrivingSpeed() {
        return 180;
    }

}
