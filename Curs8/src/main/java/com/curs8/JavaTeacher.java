package com.curs8;

import org.springframework.stereotype.Component;

@Component
public class JavaTeacher implements ITeacher{
    @Override
    public String getHomework() {
        return "homework of java teacher";
    }

    @Override
    public String getWisdom() {
        return "Java Teacher Wisdom";
    }
}
