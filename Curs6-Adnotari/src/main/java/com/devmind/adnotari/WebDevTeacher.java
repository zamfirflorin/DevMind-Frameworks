package com.devmind.adnotari;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component("webDevTeacher")
public class WebDevTeacher implements ITeacher {

    @Getter(onMethod_ = {@Override})
    private String homeWork = "Tema overrided";

//    public String getHomeWork() {
//        return "Create your server backend context!";
//    }
}