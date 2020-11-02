package ru.geekbrains.javacore.lesson01;

public class Main {
    public static void main(String[] args) {
        int i = 10;
        float f = 2.5f;
        char c = 'a';
        boolean b = true;

        System.out.println(calcExpression(2,3.2f, 5,10));
        System.out.println(isValueBetween10and20(5,2));
        System.out.println(isValuePositive(4));
        printGreeting("Влад");
        System.out.println(isLeapYear(5));
        System.out.println(isLeapYear(20));
        System.out.println(isLeapYear(100));
        System.out.println(isLeapYear(400));

    }

    static float calcExpression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    static boolean isValueBetween10and20(int a, int b) {
        int suma = a + b;
        if (suma >= 10 && suma <= 20) {
            return true;
        }
        else {
            return false;
        }
    }

    static boolean isValuePositive(int a) {
        if (a < 0) {
            return false;
        }
        else {
            return true;
        }
    }

    static void printGreeting(String name) {
        System.out.println("Привет, " + name + "!");
    }

    static boolean isLeapYear(int year) {
        if ((year%4 == 0 && year%100 !=0) || year%400 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
