package model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Curs {

    private String courseName;
    private Trainer trainer;
    private boolean online;
    private List<CourseDays> courseDays;

}
