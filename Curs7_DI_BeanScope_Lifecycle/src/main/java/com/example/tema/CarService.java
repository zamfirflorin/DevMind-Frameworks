package com.example.tema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CarService {

    @Autowired
    @Qualifier("masina")
    private Automobil automobil;

    private Autocar autocar;

    private Motocicleta motocicleta;

    public CarService(Autocar autocar) {
        this.autocar = autocar;
    }

    @Autowired
    public void setMotocicleta(Motocicleta motocicleta) {
        this.motocicleta = motocicleta;
    }

    public void travel() {
        automobil.travel();
    }

}
