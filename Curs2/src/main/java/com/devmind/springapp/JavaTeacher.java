package com.devmind.springapp;

public class JavaTeacher implements ITeacher{

    private WisdomWordsService wisdomService;

    private HomeworkService homeworkService;

    private int age;
    private String workPlace;

    public WisdomWordsService getWisdomService() {
        return wisdomService;
    }

    public void setWisdomService(WisdomWordsService wisdomService) {
        this.wisdomService = wisdomService;
    }

    public HomeworkService getHomeworkService() {
        return homeworkService;
    }

    public void setHomeworkService(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    // constructor unic care primeste ca parametru un obiect de tipul WisdomWordsService
    public JavaTeacher(WisdomWordsService wisdomService, HomeworkService homeworkService) {
        this.wisdomService = wisdomService;
        this.homeworkService = homeworkService;
    }

    @Override
    public String getHomework() {
        return "Create 100 classes";
    }

    @Override
    public String getWisdom() {
        return wisdomService.getMessage();
    }
}
