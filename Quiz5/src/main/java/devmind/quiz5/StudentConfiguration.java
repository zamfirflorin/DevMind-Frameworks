package devmind.quiz5;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("devmind.quiz5")
public class StudentConfiguration {

    @Bean
    @Scope("singleton")
    public Student student() {
        return new Student();
    }


    @Bean
    @Scope("prototype")
    public Student studentPrototype() {
        Student student = new Student();
        student.setGrade(8.2);
        student.setFirstName("florin");
        student.setLastName("zamfir");
        return student;
    }

}
