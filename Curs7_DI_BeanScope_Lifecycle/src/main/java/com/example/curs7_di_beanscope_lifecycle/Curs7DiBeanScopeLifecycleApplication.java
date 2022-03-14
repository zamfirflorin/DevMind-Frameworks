package com.example.curs7_di_beanscope_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Curs7DiBeanScopeLifecycleApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        WebDevTeacher teacher = context.getBean("webDevTeacher", WebDevTeacher.class);

        try {
            teacher.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Context closing and all beans are being destroyed");
        context.close();
    }

}
