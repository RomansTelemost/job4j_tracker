package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    public void whenItemsSortDescByName() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(5, "Request 5"));
        expected.add(new Item(3, "Request 3"));
        expected.add(new Item(1, "Request 1"));

        List<Item> list = new ArrayList<>();
        list.add(new Item(3, "Request 3"));
        list.add(new Item(1, "Request 1"));
        list.add(new Item(5, "Request 5"));
        Collections.sort(list, new ItemAscByName());
        assertThat(list).containsAll(expected);
    }
}