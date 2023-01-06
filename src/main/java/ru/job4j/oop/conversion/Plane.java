package ru.job4j.oop.conversion;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println("Приготовиться к взлету");
    }

    @Override
    public void refuel() {
        System.out.println("Залить керосин");
    }
}
