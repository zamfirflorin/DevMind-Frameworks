package com.devmind.tema;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IAnimal cat = context.getBean("cat", IAnimal.class);

        System.out.println(cat.makeSound());
    }
}
