package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerAndBiConsumer {

    /**
     * Consumer - потребитель
     * @param args
     */
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello Consumer!";
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(supplier.get());
        BiConsumer<String, Integer> biConsumer = (s, i) -> System.out.println(s + " " + i);
        biConsumer.accept(supplier.get(), 20);
        List<String> list = List.of("1", "Two", "Three");
        Supplier<Set<String>> setSupplier = () -> new HashSet<>(list);
        BiConsumer<Integer, String> biConsumer1 = (i, s) -> System.out.println(i + s);
        Set<String> strings = setSupplier.get();
        int i = 1;
        for (String s : strings) {
            biConsumer1.accept(i++, s);
        }
    }
}
