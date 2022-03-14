package com.devmind.adnotari;

import org.springframework.stereotype.Component;

@Component("webDevTeacher")
public class WebDevTeacher implements ITeacher {
    @Override
    public String getHomeWork() {
        return "Create your server backend context!";
    }
}