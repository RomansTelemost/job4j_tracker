package ru.job4j.concat;

import java.util.StringJoiner;

public class ConcatTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StringBuilder strBl = new StringBuilder("Job4j");
        for (int index = 0; index < 9999; index++) {
            strBl.append(index);
        }
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        String strCon = "Job4j";
        for (int index = 0; index < 9999; index++) {
            strCon.concat(strCon);
        }
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));
        String strJoin = String.join(" ", "abc", "def", "ghi");
        System.out.println(strJoin);
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        stringJoiner.add("abc").add("def").add("ghi");
        System.out.println(stringJoiner);
        String joined = stringJoiner.toString();
        System.out.println(joined);

    }
}
