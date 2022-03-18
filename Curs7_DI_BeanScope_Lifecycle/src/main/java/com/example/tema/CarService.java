package com.example.tema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CarService {

    //injectare prin camp
    @Autowired
    private Masina masina;

    private Autocar autocar;

    private Motocicleta motocicleta;

    //injectare prin constructor
    public CarService(Autocar autocar) {
        this.autocar = autocar;
    }

    //injectare prin setter
    @Autowired
    public void setMotocicleta(Motocicleta motocicleta) {
        this.motocicleta = motocicleta;
    }

    public void travel() {
        masina.travel();
    }

}
