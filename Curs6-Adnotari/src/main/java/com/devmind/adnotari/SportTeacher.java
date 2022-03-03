package com.devmind.adnotari;

import org.springframework.stereotype.Component;

@Component
public class SportTeacher implements ITeacher{
    @Override
    public String getHomeWork() {
        return "tema la sport";
    }
}
