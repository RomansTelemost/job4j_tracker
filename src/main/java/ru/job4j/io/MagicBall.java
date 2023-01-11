package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        int randomNumber = new Random().nextInt(3);

        String message = switch (randomNumber) {
            case 1 -> "Да";
            case 2 -> "Нет";
            default -> "Может быть";
        };
        System.out.println(message);
    }
}
