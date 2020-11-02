package ru.geekbrains.javacore.lesson02;

public class Main {
    public static void main(String[] args) {
        /*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */

        int[] arr1 = new int[10];

        System.out.println("1. Исходный массив:");
        for (int i = 0;i < 10;i++) {
            arr1[i] = (int)(Math.random()*2);
            System.out.print(arr1[i] + " ");
        }

        System.out.println("\n1. Измененный массив:");
        for (int i = 0;i < 10;i++) {
            arr1[i] = 1 - arr1[i];
            System.out.print(arr1[i] + " ");
        }



        /*
        2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */

        System.out.println("\n2. Исходный массив:");
        int[] arr2 = new int[8];
        for (int i = 0;i < 8;i++) {
            arr2[i] = i * 3;
            System.out.print(arr2[i] + " ");
        }
        /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        и числа меньшие 6 умножить на 2;
         */
        System.out.println("\n3. Измененный массив:");
        for (int i = 0;i < 8;i++) {
            if (arr2[i] < 6) {
                arr2[i] = arr2[i] * 2;
            }
            System.out.print(arr2[i] + " ");
        }

        /*
        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */


        int[][] arr4 = new int[7][7];

        for (int i = 0;i < 7;i++) {
            arr4[i][i] = 1;
        }

        System.out.println("\n4. Исходный массив:");
        for (int i = 0;i < 7;i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }


        /*
        5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
         */

        System.out.println("5. Исходный массив:");
        int[] arr5 = new int[10];

        for (int i = 0;i < 10;i++) {
            arr5[i] = (int)(Math.random()*100);
            System.out.print(arr5[i] + " ");
        }

        int value_min = arr5[0];
        int value_max = arr5[0];

        for (int i = 1;i < 10;i++) {
            if (arr5[i] < value_min) {
                value_min = arr5[i];
            }
            else
            if (arr5[i] > value_max) {
                value_max = arr5[i];
            }
        }

        System.out.println("\nминимальное значение = " + value_min);
        System.out.println("максимальное значение = " + value_max);

        /*
        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив
        , метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        граница показана символами ||, эти символы в массив не входят.
         */

        System.out.println("6. Исходный массив:");
        int[] arr6 = new int[10];
        for (int i = 0;i < 10;i++) {
            arr6[i] = (int)(Math.random()*2);
            System.out.print(arr6[i] + " ");
        }

        System.out.println("\nрезультат проверки массива: " + checkBalance(arr6));

        /*
        7. **** Написать метод, которому на вход подается одномерный массив и число n
        (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива
        на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
         */

        System.out.println("7. Исходный массив:");
        int[] arr7 = new int[10];
        for (int i = 0;i < 10;i++) {
            arr7[i] = (int)(Math.random()*10);
            System.out.print(arr7[i] + " ");
        }

        moveArray(arr7, 4);

        System.out.println("\n7. Измененный массив:");
        for (int i = 0;i < 10;i++) {
            System.out.print(arr7[i] + " ");
        }

    }

    static boolean checkBalance(int[] arr) {
        int suma = 0;
        int i;
        boolean result = false;
        for (i = 0; i < arr.length; i++) {
            suma += arr[i];
        }

        if (suma%2 == 0) {
            int half = suma / 2;
            suma = 0;
            i = 0;
            while (suma < half) {
                suma += arr[i];
                i++;
            }

            result = (suma == half);

        }

        return result;
    }

    static void moveArray(int[] arr, int n) {
        if (n >= arr.length) {
            System.out.print("Параметр n выходит за пределы массива");
            return;
        }

        int i;

        if (n > 0) {
            for(i = arr.length - 1; i >= n; i--) {
                arr[i] = arr[i-n];
            }
            for(i = n - 1; i >= 0; i--) {
                arr[i] = 0;
            }
        }
        else {
            n *= -1;
            for(i = 0; i < arr.length - n; i++) {
                arr[i] = arr[i+n];
            }
            for(i = arr.length - n ; i < arr.length; i++) {
                arr[i] = 0;
            }
        }

    }
}
