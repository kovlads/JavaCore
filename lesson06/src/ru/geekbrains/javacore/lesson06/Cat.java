package ru.geekbrains.javacore.lesson06;

public class Cat extends Animal {

    public Cat(float maxRunDistance, float maxJumpHeight) {
        super(maxRunDistance, 0, maxJumpHeight);
    }


    @Override
    public void swim(float distance) {
        System.out.println("Cats can't swim!");
    }

}
