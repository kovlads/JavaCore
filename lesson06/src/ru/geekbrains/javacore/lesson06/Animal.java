package ru.geekbrains.javacore.lesson06;

public abstract class Animal {
    protected float maxRunDistance;
    protected float maxSwimDistance;
    protected float maxJumpHeight;

    public Animal(float maxRunDistance, float maxSwimDistance, float maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public void run(float distance) {
        System.out.println(this.getClass().getSimpleName() + " run: " + isCorrectAction(distance, maxRunDistance));
    }

    public void swim(float distance) {
        System.out.println(this.getClass().getSimpleName() + " swim: " + isCorrectAction(distance, maxSwimDistance));
    }

    public void jump(float height) {
        System.out.println(this.getClass().getSimpleName() + " jump: " + isCorrectAction(height, maxJumpHeight));
    }

    private boolean isCorrectAction(float value, float maxvalue) {
        return value <= maxvalue;
    }

}
