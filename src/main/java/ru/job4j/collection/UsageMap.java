package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");

        for (String key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }
    }
}
