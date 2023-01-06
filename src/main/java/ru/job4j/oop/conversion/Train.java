package ru.job4j.oop.conversion;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("Поезд отправляется. Всем уйти с путей.");
    }

    @Override
    public void refuel() {
        System.out.println("Заправить дизелем");
    }
}
