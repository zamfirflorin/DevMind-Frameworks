package devmind.quiz5;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Setter
@Getter
@Component
public class Student {


    private String lastName;
    private String firstName;
    private double grade;

}
