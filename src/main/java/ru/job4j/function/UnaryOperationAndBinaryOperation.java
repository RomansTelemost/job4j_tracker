package ru.job4j.function;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperationAndBinaryOperation {

    /**
     * Расширяют Function -> UnaryOperation
     * и BiFunction ->BinaryOperation
     * @param args
     */
    public static void main(String[] args) {
        UnaryOperator<StringBuilder> unaryOperator = b -> b.reverse();
        System.out.println("После реверса "
                + unaryOperator.apply(new StringBuilder("String for test!")));
        System.out.println("После реверса "
                + unaryOperator.apply(new StringBuilder("!tset rof gnirtS")));
        BinaryOperator<StringBuilder> binaryOperator = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println("После объединения "
                + binaryOperator.apply(new StringBuilder("A"), new StringBuilder("B")));
    }
}
