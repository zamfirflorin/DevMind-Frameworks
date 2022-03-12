package com.devmind.tema;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TemaMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Task task = context.getBean("task", Task.class);
        Task tas2 = context.getBean("task", Task.class);

        task.run();
        tas2.run();
        context.close();

    }

}
