package ru.job4j.tracker;

import ru.job4j.tracker.repository.MemTracker;

import java.util.List;

public class SingleTracker {

    private static SingleTracker singleTracker = null;
    private MemTracker tracker = new MemTracker();

    private SingleTracker() {
    }

    public static SingleTracker getSingleTrackerInstance() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

}
