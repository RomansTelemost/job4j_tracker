package ru.job4j.checkstyle;

public class Broken {
    private int sizeOfEmpty = 10;

    private String name;

    private String surname;

    public static final String NEW_VALUE = "";

    public Broken() { }

    void echo() { }

    void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    void firstMethod(int a, int b, int c, int d) {

    }

    void secondMethod(int e, int f, int g, int h) {

    }
}