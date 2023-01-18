package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    public void whenItemsSortAscByName() {
        Item item1 = new Item(1, "Request 1");
        Item item3 = new Item(3, "Request 3");
        Item item5 = new Item(5, "Request 5");

        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item3);
        expected.add(item5);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item3);
        list.add(item5);
        Collections.sort(list, new ItemAscByName());
        assertThat(list).containsAll(expected);
    }
}