package ru.job4j.inheritance;

public class TextReport {

    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }

    public static int testStaticMethodOverriding(String sss) {
        System.out.println(sss);
        return 1;
    }

}
