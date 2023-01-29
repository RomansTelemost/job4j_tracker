package ru.job4j.stream.api;

import java.util.List;

public class DropWhile {

    /**
     * Когда обрабатывается число 3 условие v -> v < 3 становится "истина".
     * Все дальнейшие элементы проходят дальше.
     * @param args
     */
    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 0, 1).stream()
                .dropWhile(v -> v < 3)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }
}
