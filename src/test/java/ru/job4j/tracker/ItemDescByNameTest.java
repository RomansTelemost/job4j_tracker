package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    public void whenItemsSortDescByName() {
        Item item1 = new Item(1, "Request 1");
        Item item3 = new Item(3, "Request 3");
        Item item5 = new Item(5, "Request 5");

        List<Item> expected = new ArrayList<>();
        expected.add(item5);
        expected.add(item3);
        expected.add(item1);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item3);
        list.add(item5);
        Collections.sort(list, new ItemDescByName());
        assertThat(list).containsAll(expected);
    }
}