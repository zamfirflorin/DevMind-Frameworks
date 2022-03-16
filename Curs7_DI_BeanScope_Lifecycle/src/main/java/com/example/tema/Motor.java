package com.example.tema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Motor {

    private int putere;
    private int nume;
    private int numarCilindri;

}
