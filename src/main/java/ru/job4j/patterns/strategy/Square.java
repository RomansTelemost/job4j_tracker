package ru.job4j.patterns.strategy;

public class Square implements Shape {

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "|¯¯¯¯¯¯| " + ln
                + "|      | " + ln
                + "|______| " + ln;
    }
}
