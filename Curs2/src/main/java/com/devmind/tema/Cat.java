package com.devmind.tema;

public class Cat implements  IAnimal{

    private String animalName;

    public Cat(String name) {
        this.animalName = name;
    }

    @Override
    public String makeSound() {
        return "cat meow meow meow";
    }
}
