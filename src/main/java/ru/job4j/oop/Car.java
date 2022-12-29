package ru.job4j.oop;

public class Car {
    private String brand;
    private String model;
    private static String carManual = "Инструкция к автомобилю";

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Двигатель запущен");
    }

    public static TripComputer getTripComputer() {
        Car car = new Car("", "");
        Car.TripComputer tr = car.new TripComputer();
        return tr;
    }

    public class Transmission {

        public void accelerate() {
            System.out.println("Ускорение");
        }
    }

    public class Brakes {

        public void brake() {
            System.out.println("Торможение");
        }
    }

    public class TripComputer {

        public String info = "Бортовой компьютер";
        private String model = "Модель TripComputer";

        public void getInfo() {
            System.out.println("Марка: " + brand);
            System.out.println("Модель: " + this.model);
            System.out.println("Модель: " + Car.this.model);
        }
    }

    public static class Manual {

        public static String getManual() {
            return carManual;
        }
    }
}
