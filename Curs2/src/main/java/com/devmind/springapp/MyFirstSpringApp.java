package com.devmind.springapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyFirstSpringApp {

    public static void main(String[] args) {

        // create the object
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ITeacher teacher = context.getBean("myTeacher", ITeacher.class);

        // use the object
        //System.out.println(teacher.getHomework());

        JavaTeacher javaSecondTeacher = (JavaTeacher) context.getBean("javaTeacher", ITeacher.class);
        System.out.println(javaSecondTeacher.getWisdom());
        // call methods on the bean
        System.out.println("Wisdom: " + javaSecondTeacher.getWisdom());
        System.out.println("Age: " + javaSecondTeacher.getAge());
        System.out.println("Work place: " + javaSecondTeacher.getWorkPlace());

    }
}
