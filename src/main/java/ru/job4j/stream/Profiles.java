package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return collect(profiles).stream()
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(
                List.of(1, 1, 2, 2).stream()
                        .collect(Collectors.toMap(
                                e -> e,
                                e -> e * e,
                                (existing, replacement) -> existing
                        ))
        );
    }
}
