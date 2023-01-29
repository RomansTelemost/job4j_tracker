package ru.job4j.stream.mapto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapToIntExample {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] array3 = {7, 8, 9};
        List<Integer> integerList = Stream.of(array1, array2, array3)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(integerList);
        List<String> stringList = IntStream.rangeClosed(1, 5)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(stringList);
        List<String> list1 = List.of("1", "2", "3");
        List<String> list2 = List.of("4", "5", "6");
        List<String> list3 = List.of("7", "88", "99");
        List<String> ss = Stream.of(list1, list2, list3)
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toList());
        System.out.println(ss);
        List<String> ss1 = Stream.of(list1, list2)
                .flatMap(strings -> strings.stream()).toList();
        System.out.println(ss1);
        String[] arr1 = new String[]{"1"};
        String[] arr2 = new String[]{"2"};
        String[] arr3 = new String[]{"3"};
        stringList = Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).toList();
        System.out.println(stringList);
        List<String> s1 = Stream.of("a", "б")
                .map(String::toUpperCase)
                .toList();
        System.out.println(s1);
    }
}
