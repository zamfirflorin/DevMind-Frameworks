package com.example.tema;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TemaMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CarService carService = context.getBean("carService", CarService.class);

        carService.travel();
        carService.getAutocar().travel();
        carService.getMotocicleta().travel();

        NewCarService newCarService = context.getBean("newCarService", NewCarService.class);
        newCarService.getMasina().travel();

    }

}
