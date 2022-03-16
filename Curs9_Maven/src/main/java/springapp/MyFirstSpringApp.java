package springapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyFirstSpringApp {

    public static void main(String[] args) {

        // create the object
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("springapp");

        ITeacher teacher = context.getBean("mathTeacher", ITeacher.class);

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
