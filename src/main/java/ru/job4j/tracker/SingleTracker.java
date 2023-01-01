package ru.job4j.tracker;

public class SingleTracker {

    private static SingleTracker singleTracker = null;
    private Tracker tracker = new Tracker();

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

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }
}
