package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class Curs {

    private String name;
    private Trainer trainer;
    private boolean online;
    private List<CourseDays> courseDays;

}
