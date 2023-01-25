package ru.job4j.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAndBiFunction {

    public static void main(String[] args) {
        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке " + func.apply("first"));
        System.out.println("Третий символ в строке " + func.apply("second"));
        BiFunction<String, Integer, String> biFunction =
                (s, i) -> s.concat(" ").concat(i.toString());
        System.out.println(biFunction.apply("Pojo", 12));
    }
}
