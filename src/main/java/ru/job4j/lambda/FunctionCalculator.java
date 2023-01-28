package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> doubles = new ArrayList<>();
        for (double i = start; i < end; i++) {
            doubles.add(func.apply(i));
        }
        return doubles;
    }
}
