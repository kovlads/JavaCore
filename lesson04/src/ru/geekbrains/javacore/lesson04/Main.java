package ru.geekbrains.javacore.lesson04;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static int lastX;
    public static int lastY;

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
        lastX = x;
        lastY = y;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
        lastX = x;
        lastY = y;
    }


    public static boolean isColumnWin(char symb) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][lastX] == symb) {
                count += 1;
            }
            else {
                count = 0;
            }
            if (count == DOTS_TO_WIN) {
                break;
            }
        }
        return count == DOTS_TO_WIN;
    }

    public static boolean isRowWin(char symb) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[lastY][i] == symb) {
                count += 1;
            }
            else {
                count = 0;
            }
            if (count == DOTS_TO_WIN) {
                break;
            }
        }
        return count == DOTS_TO_WIN;
    }

    public static boolean isFirstDiagonalWin(char symb) {
        int i = 0;
        int count = 0;
        int startX;
        int startY;
        if (lastX > lastY) {
            startX = 0;
            startY = lastX - lastY;
        }
        else {
            startX = lastY - lastX;
            startY = 0;
        }
        do {
            if (map[startY][startX] == symb) {
                count += 1;
            }
            else {
                count = 0;
            }
            startX += 1;
            startY += 1;

        }
        while (startX < SIZE && startY < SIZE && count < DOTS_TO_WIN);
        return count == DOTS_TO_WIN;
    }

    public static boolean isSecondDiagonalWin(char symb) {
        int i = 0;
        int count = 0;
        int startX;
        int startY;
        int diff;
        if (lastY > SIZE - lastX - 1) {
            diff = SIZE - lastX - 1;
        }
        else {
            diff = lastY;
        }
        startX = lastX + diff;
        startY = lastY - diff;
        do {
            if (map[startY][startX] == symb) {
                count += 1;
            }
            else {
                count = 0;
            }
            startX -= 1;
            startY += 1;

        }
        while (startX >=0 && startY < SIZE && count < DOTS_TO_WIN);
        return count == DOTS_TO_WIN;
    }

    public static boolean checkWin(char symb) {
        if (isRowWin(symb)) return true;
        if (isColumnWin(symb)) return true;
        if (isFirstDiagonalWin(symb)) return true;
        if(isSecondDiagonalWin(symb)) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }


}
