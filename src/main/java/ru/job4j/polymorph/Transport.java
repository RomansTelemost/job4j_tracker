package ru.job4j.polymorph;

public interface Transport {

    void drive();

    void passengers(int countOfPassengers);

    int refill(int volume);
}
