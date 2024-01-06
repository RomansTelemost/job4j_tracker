package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.repository.MemTracker;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemTrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindById() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindAll() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName()).isEqualTo(first.getName());
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName()).isEqualTo(second.getName());
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        Item updateItem = new Item("Bug with description");
        tracker.replace(id, updateItem);
        assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Bug");
        tracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        MemTracker tracker = new MemTracker();
        Item item1 = new Item("Bug1");
        Item item2 = new Item("Bug2");
        Item item3 = new Item("Bug3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        int id = item2.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
        assertThat(tracker.findAll().size()).isEqualTo(2);
        assertThat(tracker.findAll().get(0)).isEqualTo(item1);
        assertThat(tracker.findAll().get(1)).isEqualTo(item3);
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        MemTracker tracker = new MemTracker();
        Item item1 = new Item("Bug1");
        Item item2 = new Item("Bug2");
        Item item3 = new Item("Bug3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        boolean result = tracker.delete(1000);
        assertThat(tracker.findById(item1.getId()).getName()).isEqualTo("Bug1");
        assertThat(result).isFalse();
        assertThat(tracker.findAll().size()).isEqualTo(3);
        assertThat(tracker.findAll().get(0)).isEqualTo(item1);
        assertThat(tracker.findAll().get(1)).isEqualTo(item2);
        assertThat(tracker.findAll().get(2)).isEqualTo(item3);
    }
}