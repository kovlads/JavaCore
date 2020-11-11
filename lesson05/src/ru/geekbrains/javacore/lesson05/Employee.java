package ru.geekbrains.javacore.lesson05;

public class Employee {
    String name;
    String post;
    String email;
    String phone;
    int salary;
    int age;

    public Employee(String name, String post, String email, String phone, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Имя сотрудника: " + name
                + "; Должность: " + post
                + "; Email: " + email
                + "; Телефон: " + phone
                + "; Зарплата: " + salary
                + "; Возраст: " + age
        );
    }

}
