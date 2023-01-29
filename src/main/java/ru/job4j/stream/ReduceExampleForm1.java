package ru.job4j.stream;

import java.util.List;
import java.util.Optional;

public class ReduceExampleForm1 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        Optional<Integer> sum = nums.stream()
                .reduce((a, b) -> a + b);
        System.out.println(sum.get());
        List<String> strings = List.of("Один", "Два", "Три");
        Optional<String> stringsSum = strings.stream()
                .reduce((a, b) -> a + " * " + b);
        System.out.println(stringsSum.get());

    }
}
