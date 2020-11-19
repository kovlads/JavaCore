package ru.geekbrains.javacore.lesson07;


public class Plate {
    private int capacity;
    private int food;

    public Plate(int food) {
        this.capacity = food;
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public boolean decreaseFood(int n) {
        if (food < n) {
            return false;
        }
        else {
            food -= n;
            return true;
        }
    }

    public void increaseFood(int n) {
        food += n;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFood() {
        return food;
    }
}

