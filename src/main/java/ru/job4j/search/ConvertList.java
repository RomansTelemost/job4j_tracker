package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] row : list) {
            for (int number : row) {
                rsl.add(number);
            }
        }
        return rsl;
    }
}
