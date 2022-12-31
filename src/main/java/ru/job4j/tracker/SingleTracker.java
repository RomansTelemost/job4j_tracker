package ru.job4j.tracker;

public class SingleTracker {

    private static SingleTracker singleTracker = null;
    private Tracker tracker = null;

    private SingleTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public static SingleTracker getSingleTrackerInstance() {
        if (singleTracker == null) {
            return new SingleTracker(new Tracker());
        } else {
            return singleTracker;
        }
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
