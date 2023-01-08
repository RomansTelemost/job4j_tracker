package ru.job4j.checkstyle;

public class Broken {
    private int sizeOfEmpty = 10;

    private String name;

    private String surname;

    public static final String NEW_VALUE = "";

    public Broken() { }

    public void echo() { }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void firstMethod(int a, int b, int c, int d) {

    }

    public void secondMethod(int e, int f, int g, int h) {

    }
}