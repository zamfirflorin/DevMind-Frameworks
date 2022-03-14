package com.devmind.adnotari;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyFirstSpringAnnotationApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.devmind.adnotari");

        ITeacher teacher = context.getBean("webDevTeacher", ITeacher.class);
        ITeacher sportTeacher = context.getBean("sportTeacher", ITeacher.class);

        System.out.println(teacher.getHomeWork());
        System.out.println(sportTeacher.getHomeWork());

        context.close();
    }
}
