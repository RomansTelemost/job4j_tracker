package ru.job4j.stream.api;

import java.util.List;

public class TakeWhile {

    /**
     * Когда поток обрабатывает число 3 условие принимает
     * значение "ложь" и поток данных завершается.
     * @param args
     */
    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 0).stream()
                .takeWhile(v -> v < 3)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }
}
