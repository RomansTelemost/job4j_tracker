package ru.job4j.polymorph;

public class Main {

    public static void main(String[] args) {
        Vehicle car = new SportCar();
        car.changeGear();
        car.accelerate();
        car.steer();
        car.brake();
        car.refill();
        Vehicle.getDragCoefficient();
        car.chargeBattery();
    }
}
