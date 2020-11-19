package ru.geekbrains.javacore.lesson07;


public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    public static int countCats = 0;

    public Cat(int appetite) {
        this.appetite = appetite;
        this.satiety = false;
        this.countCats += 1;
        this.name = "Cat #" + this.countCats;

    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
        this.countCats += 1;
    }

    public void eat(Plate p) {
        satiety = p.decreaseFood(appetite);
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void info() {
        System.out.println("cat name: " + name + ", appetite: " + appetite);
    }

    public String getName() {
        return name;
    }
}

