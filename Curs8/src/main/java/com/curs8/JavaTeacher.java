package com.curs8;

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
