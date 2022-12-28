package ru.job4j.oop;

import java.util.Collections;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int number) {
        return number - x;
    }

    public double divide(int number) {
        return number / x;
    }

    public double sumAllOperation(int number) {
        return sum(number) + multiply(number) + minus(x) + divide(x);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        double sumAllOperations = calculator.sumAllOperation(4);
        System.out.println(sumAllOperations);
    }
}
