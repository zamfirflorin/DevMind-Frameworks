package com.devmind.tema;

import java.util.Random;

public class Task {

    static int numberOfTasks = 0;
    private String taskName;
    private static Integer taskId = 1;
    private Integer executionTime;

    private Random random;

    public Task() {
        numberOfTasks++;
    }

    public void run()  {
        try {
            Thread.sleep(executionTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  Integer generateId() {
       return numberOfTasks;
    }

    private void init() {
        System.out.println("This method is called at initialization");
        this.taskId = generateId();
        this.taskName = "Task_" + taskId;
        System.out.println("Numele obiectului creat este " + this.taskName);
        this.executionTime = new Random().nextInt(1, 20);
    }

    private void destroy() {
        System.out.println("Numele obiectului distrus este " + this.taskName);
        numberOfTasks--;
        System.out.println("This method is called at destruction. Use this to free resources.");
    }

}
