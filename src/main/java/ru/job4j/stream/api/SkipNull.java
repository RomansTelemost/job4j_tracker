package ru.job4j.stream.api;

import java.util.stream.Stream;

public class SkipNull {

    /**
     * сделает из элемента поток, если элемент равен null, то элемент пропускается
     * @param args
     */
    public static void main(String[] args) {
        Stream.of(1, null, 2, null, 3)
                .flatMap(Stream::ofNullable)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }
}
