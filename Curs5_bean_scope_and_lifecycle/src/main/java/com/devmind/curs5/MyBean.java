package com.devmind.curs5;

public class MyBean {
    static int objectCounter = 0;
    public MyBean() {
        objectCounter++;
        System.out.println("Current number of instances: " + objectCounter);
    }
    private void performInitialization() {
        System.out.println("This method is called at initialization");
    }

    private void performDestruction() {
        System.out.println("This method is called at destruction. Use this to free resources.");
    }
}
