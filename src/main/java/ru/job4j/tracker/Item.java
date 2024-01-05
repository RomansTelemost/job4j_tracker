package ru.job4j.tracker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    public Item(String name) {
        this.name = name;
    }

    public Item(int id) {
        this.id = id;
    }
}