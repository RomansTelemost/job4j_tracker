package ru.job4j.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Of {

    public static void main(String[] args) {
        List.of(5, 1, 2).forEach(System.out::println);
        Set.of(5, 1, 2).forEach(System.out::println);
        Map.of("first", 1, "second", 2)
                .forEach((v, k) -> System.out.println(v + " " + k));
        List<Integer> expected1 = Arrays.asList(1, 2, 3);
        List<Integer> expected2 = List.of(1, 2, 3);
    }
}
