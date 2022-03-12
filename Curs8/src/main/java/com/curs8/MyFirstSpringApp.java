package com.curs8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyFirstSpringApp {

    public static void main(String[] args) {

        System.out.println(" ----- Before context initialization ----- ");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TeacherConfiguration.class);
        ServiceA serviceA = context.getBean(ServiceA.class);
        ServiceB serviceB = context.getBean(ServiceB.class);

        ITeacher teacher = context.getBean("javaTeacher", JavaTeacher.class);

        System.out.println(teacher.getWisdom());

        // close the context
        context.close();
        System.out.println(" ----- After context closed ----- ");

    }

}
