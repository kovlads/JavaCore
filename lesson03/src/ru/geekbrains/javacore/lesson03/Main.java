package ru.geekbrains.javacore.lesson03;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите игру:");
            System.out.println("1. угадай число");
            System.out.println("2. угадай слово");
            System.out.println("0. выход");
            int choice = scanner.nextInt();
            if (choice == 1) {
                playGuessTheNumber();
            }
            else if (choice == 2) {
                playGuessTheWord();
            }
            else {
                break;
            };
        }

    }

    static void playGuessTheNumber() {
        while (true) {
            guess_the_number(10, 3);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            if (scanner.nextInt() != 1) {
                break;
            };
        }

    }

    static void guess_the_number(int range, int max_answers) {
        int number = (int)(Math.random() * range);

        int num_answer = 0;
        int input_number;

        System.out.println("Угадайте число от 0 до " + range);

        while (num_answer < max_answers) {
            input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println("Вы угадали");
                break;
            }
            else if (input_number > number) {
                System.out.println("Загаданное число меньше");
            }
            else {
                System.out.println("Загаданное число больше");
            }

            num_answer++;

        }

        if (num_answer == max_answers) {
            System.out.println("Вы не смогли отгадать загаданное число "+number);
        }

    }

    static void playGuessTheWord() {
        while (true) {
            guess_the_word();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            if (scanner.nextInt() != 1) {
                break;
            };
        }

    }

    static void guess_the_word() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli"
                , "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom"
                , "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        int word_number = (int)(Math.random() * (words.length + 1));

        String input_word;

        while (true) {
            System.out.println("Введите слово");
            input_word = scanner.nextLine();
            if (input_word.equalsIgnoreCase(words[word_number])) {
                System.out.println("Вы угадали");
                break;
            }

            System.out.println(compare_words(input_word, words[word_number]));

        }


    }

    static String compare_words(String first, String second) {
        String result = "";
        int len = (first.length() < second.length())?first.length():second.length();

        for(int i = 0; i < 15; i++) {
            result += (i < len && first.charAt(i) == second.charAt(i))?first.charAt(i):'#';
        }

        return result;

    }

}
