package com.devmind.springapp;

public class HistoryTeacher implements ITeacher{

    @Override
    public String getHomework() {
        return "Learn about WW1";
    }

    @Override
    public String getWisdom() {
        return null;
    }

}
