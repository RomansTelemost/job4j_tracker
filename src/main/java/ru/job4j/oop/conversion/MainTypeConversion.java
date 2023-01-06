package ru.job4j.oop.conversion;

public class MainTypeConversion {

    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = {plane, train, bus};
        for (Vehicle vehicle : vehicles) {
            vehicle.refuel();
            vehicle.move();
        }
    }
}
