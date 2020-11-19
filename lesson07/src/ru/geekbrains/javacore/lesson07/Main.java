package ru.geekbrains.javacore.lesson07;

import java.util.Random;

/*
+2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20)
+3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true
+4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт
(это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию
о сытости котов в консоль
+6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */
public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        int range = 10;
        int plateVolume = 100;

        //будем ли подсыпать еду, если кот не поел
        boolean isFeedKind = false;


        Cat[] cats = new Cat[range];

        Plate plate = new Plate(plateVolume);
        plate.info();

        // создаем котов
        System.out.println("Cats: ");
        for (int i = 0; i < range; i++) {
            cats[i] = createCat();
            cats[i].info();
        }

        System.out.println("Feed cats: ");
        for (int i = 0; i < range; i++) {
            cats[i].eat(plate);
            if (isFeedKind && !cats[i].isSatiety()) {
                do {
                    fillPlate(plate);
                    cats[i].eat(plate);
                }
                while (!cats[i].isSatiety());
            }
            System.out.println(cats[i].getName() + " satiety is " + cats[i].isSatiety());
            plate.info();
        }



    }

    static Cat createCat() {
        int appetite = 20 + random.nextInt(10);
        return new Cat(appetite);
    }

    static void fillPlate(Plate plate) {
        int foodToFill = random.nextInt(plate.getCapacity() - plate.getFood()) + 1;
        plate.increaseFood(foodToFill);
        System.out.println("add to plate " + foodToFill + " food");
    }


}
