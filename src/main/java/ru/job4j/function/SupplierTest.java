package ru.job4j.function;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class SupplierTest {

    /**
     * Поставщик
     * @param args
     */
    public static void main(String[] args) {
        Supplier<String> sup = () -> "Hello supplier!";
        System.out.println(sup.get());
        Supplier<Set<String>> setSupplier = () -> new HashSet<>();
        Set<String> strings = setSupplier.get();
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
