package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupExample {

    public static void main(String[] args) {
        System.out.println("MapList");
        List<Worker> workers = List.of(
                new Worker("Name1", 1, 100, "IT1"),
                new Worker("Name2", 2, 200, "IT1"),
                new Worker("Name2", 2, 200, "IT1"),
                new Worker("Name1", 3, 300, "IT2"),
                new Worker("Name4", 4, 400, "IT2"),
                new Worker("Name5", 5, 500, "IT3")
        );
        Map<String, List<Worker>> mapList = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition));
        for (Map.Entry<String, List<Worker>> entry : mapList.entrySet()) {
            System.out.println("Dep " + entry.getKey());
            for (Worker worker : mapList.get(entry.getKey())) {
                System.out.println(worker.getName());
            }
            System.out.println("");
        }
        System.out.println("MapSetWorker");
        Map<String, Set<Worker>> mapSet = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()));
        for (Map.Entry<String, Set<Worker>> entry : mapSet.entrySet()) {
            System.out.println("Dep " + entry.getKey());
            for (Worker worker : mapList.get(entry.getKey())) {
                System.out.println(worker.getName());
            }
            System.out.println("");
        }
        System.out.println("MapLong");
        Map<String, Long> mapLong = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));
        for (Map.Entry<String, Long> entry : mapLong.entrySet()) {
            System.out.println(entry.getKey() + " + " + entry.getValue());
        }
        System.out.println("MapSetString");
        Map<String, Set<String>> map4 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.mapping(Worker::getName, Collectors.toSet())));
        for (Map.Entry<String, Set<String>> entry : map4.entrySet()) {
            System.out.println("Dep " + entry.getKey());
            for (String s : map4.get(entry.getKey())) {
                System.out.println(s);
            }
            System.out.println("");
        }
        System.out.println("StringDouble - AverageSalary");
        Map<String, Double> mapAvSalary = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.averagingDouble(Worker::getSalary)));
        for (Map.Entry<String, Double> entry : mapAvSalary.entrySet()) {
            System.out.println(entry.getKey() + " + " + entry.getValue());
        }
        System.out.println("Group name");
        Map<String, String> stringStringMap = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.mapping(Worker::getName,
                                Collectors.joining(", ", "{", "}"))));
        for (Map.Entry<String, String> entry : stringStringMap.entrySet()) {
            System.out.println(entry.getKey() + " + " + entry.getValue());
        }
        System.out.println("Double group");
        Map<String, Map<Integer, List<Worker>>> stringMapMap = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.groupingBy(Worker::getAge)));
        for (Map.Entry<String, Map<Integer, List<Worker>>> entry : stringMapMap.entrySet()) {
            System.out.println("Dep " + entry.getKey());
            for (Map.Entry<Integer, List<Worker>> m : stringMapMap.get(entry.getKey()).entrySet()) {
                System.out.println("Age " + m.getKey());
                for (Worker worker : m.getValue()) {
                    System.out.println(worker);
                }
            }
            System.out.println("");
        }
    }
}
