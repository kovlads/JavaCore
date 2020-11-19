package ru.geekbrains.javacore.lesson06;
/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
или высоту (для прыжков).
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
 плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
(Например, dog1.run(150); -> результат: run: true)
5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м.,
у другой 600 м.
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Cat murka = new Cat(200, 2);
        Dog sharik = new Dog(500, 0.5f, 10);

        murka.run(100);
        murka.swim(2);
        murka.jump(2.2f);

        sharik.run(150f);
        sharik.run(500.3f);
        sharik.swim(4);
        sharik.jump(0.7f);

        Animal randomCat = createCat();
        Animal randomDog = createDog();

        System.out.println("random cat: max run = " + randomCat.maxRunDistance
                + ", max jump = " + randomCat.maxJumpHeight);

        randomCat.run(180);
        randomCat.jump(1);

        System.out.println("random dog: max run = " + randomDog.maxRunDistance
                + ", max swim = " + randomDog.maxSwimDistance
                + ", max jump = " + randomDog.maxJumpHeight);

        randomDog.run(20);
        randomDog.swim(1.5f);
        randomDog.jump(0.3f);

    }

    static Animal createCat() {
        Random random = new Random();

        float maxRun = random.nextInt(200) + random.nextFloat();
        float maxJump = random.nextInt(3) + random.nextFloat();

        return new Cat(maxRun, maxJump);
    }

    static Animal createDog() {
        Random random = new Random();

        float maxRun = random.nextInt(500) + random.nextFloat();
        float maxSwim = random.nextInt(1) + random.nextFloat();
        float maxJump = random.nextInt(2) + random.nextFloat();

        return new Dog(maxRun, maxSwim, maxJump);
    }

}
