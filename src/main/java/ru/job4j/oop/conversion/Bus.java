package ru.job4j.oop.conversion;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Автобус отправляется");
    }

    @Override
    public void refuel() {
        System.out.println("Заправить бензином");
    }
}
