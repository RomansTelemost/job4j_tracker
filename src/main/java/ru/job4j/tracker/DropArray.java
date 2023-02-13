package ru.job4j.tracker;

import java.util.Arrays;

public class DropArray {

    public static void main(String[] args) {
        String[] names = {"Petr", null, "Ivan", "Stepan", null};
        String[] rsl = new String[names.length];
        int size = 0;
        for (int index = 0; index < names.length; index++) {
            String name = names[index];
            if (name != null) {
                rsl[size] = name;
                size++;
            }
        }
        /**
         * rsl = Arrays.copyOf(rsl, size);
         * for (int index = 0; index < rsl.length; index++) {
         *  System.out.println(rsl[index]);
         * }
         */

        String[] newRsl = Arrays.copyOf(rsl, rsl.length);
        /**
         * От куда,
         * с какого индекса берем данные из "От куда",
         * Куда,
         * с какого индекска начинаем вставку, сколько элементов вставить из "От куда".
         */
        System.arraycopy(rsl, 2, newRsl, 1, 1);
        newRsl[2] = null;
        System.out.println(Arrays.toString(newRsl));
    }
}
