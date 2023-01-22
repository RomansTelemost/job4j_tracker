package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.parseInt(left.substring(0, left.indexOf(".")))
                - Integer.parseInt(right.substring(0, right.indexOf(".")));
    }
}
