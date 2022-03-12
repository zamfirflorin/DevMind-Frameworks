package com.devmind.curs5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        // load the spring configuration file


        System.out.println("----- Before context initialization");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("----- Before getBean calls");

        context.getBean("prototypeBean", MyBean.class);
        System.out.println("----- After getBean calls");
        System.out.println("Current number of instances: " + MyBean.objectCounter);

        // close the context
        context.close();
        System.out.println("----- After context closed");

    }
}
