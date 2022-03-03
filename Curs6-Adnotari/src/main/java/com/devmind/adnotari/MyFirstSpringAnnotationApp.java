package com.devmind.adnotari;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyFirstSpringAnnotationApp {

    public static void main(String[] args) {
        // citeste fisierul de configurare
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // obtine bean-ul din container-ul de spring
        ITeacher teacher = context.getBean("ourOwnDevTeacher", ITeacher.class);
        ITeacher sportTeacher = context.getBean("sportTeacher", ITeacher.class);
        // foloseste functionalitatile bean-ului
        System.out.println(teacher.getHomeWork());
        System.out.println(sportTeacher.getHomeWork());
        // inchide contextul
        context.close();
    }
}
