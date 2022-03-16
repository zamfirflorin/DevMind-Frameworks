package com.example.tema;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TemaMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CarService car = context.getBean("carService", CarService.class);

        car.travel();

    }

}
