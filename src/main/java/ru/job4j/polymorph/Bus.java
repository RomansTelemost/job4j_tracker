package ru.job4j.polymorph;

public class Bus implements Transport {

    private int countOfPassengers;
    private int volumeOfFuel;

    private static int price;

    public int getCountOfPassengers() {
        return countOfPassengers;
    }

    public void setCountOfPassengers(int countOfPassengers) {
        this.countOfPassengers = countOfPassengers;
    }

    public int getVolumeOfFuel() {
        return volumeOfFuel;
    }

    public void setVolumeOfFuel(int volumeOfFuel) {
        this.volumeOfFuel = volumeOfFuel;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Bus.price = price;
    }

    @Override
    public void drive() {
        System.out.println("Начало движения Bus");
    }

    @Override
    public void passengers(int countOfPassengers) {
        this.countOfPassengers += countOfPassengers;
    }

    @Override
    public int refill(int volume) {
        volumeOfFuel += volume;
        return volume * Fuel.PRICE;
    }
}
