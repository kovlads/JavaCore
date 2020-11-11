package ru.geekbrains.javacore.lesson05;

public class Main {
    public static void main(String[] args) {
        int range = 5;
        Employee[] employees = new Employee[range];
        employees[0] = new Employee("Миллер Алексей"
                ,"председатель"
                , "a.miller@mail.ru"
                , "8-800-0001"
                , 1000000
                , 58
        );
        employees[1] = new Employee("Путин Михаил"
                ,"заместитель председателя"
                , "m.putin@mail.ru"
                , "8-800-0002"
                , 800000
                , 38
        );
        employees[2] = new Employee("Хомяков Сергей"
                ,"директор службы защиты"
                , "s.homyakov@mail.ru"
                , "8-800-0003"
                , 600000
                , 65
        );
        employees[3] = new Employee("Михайлова Елена"
                ,"начальник департамента"
                , "e.mihaylova@mail.ru"
                , "8-800-0105"
                , 300000
                , 32
        );
        employees[4] = new Employee("Марков Владимир"
                ,"начальник департамента"
                , "v.markov@mail.ru"
                , "8-800-0308"
                , 350000
                , 52
        );

        for (int i = 0; i < range; i++) {
            if (employees[i].age > 40) {
                employees[i].info();
            }
        }
    }

}
