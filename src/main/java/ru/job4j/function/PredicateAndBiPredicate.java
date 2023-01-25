package ru.job4j.function;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateAndBiPredicate {

    /**
     * Predicate - утверждение
     * @param args
     */
    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.isEmpty();
        System.out.println(predicate.test(""));
        System.out.println(predicate.test(" "));
        System.out.println(predicate.test("Test"));
        BiPredicate<String, Integer> contains = (s, i) -> s.contains(i.toString());
        System.out.println(contains.test("1pop", 1));

    }
}
