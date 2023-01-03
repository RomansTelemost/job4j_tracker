package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[100];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[counter] = items[i];
                counter++;
            }
        }
        return Arrays.copyOf(result, counter);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = null;
            size--;
            System.arraycopy(items, index + 1, items, index, size);
            items[size] = null;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        int[] b = new int[10];
        for (int i = 0; i < b.length; i++) {
            b[i] = 1;
        }
        a[3] = 0;
        System.out.println("Before " + Arrays.toString(a));
        System.out.println("Before b " + Arrays.toString(b));
        System.arraycopy(a, 4, b, 3, 6);
        System.out.println("After " + Arrays.toString(b));

        // src - источник
        // srcPos - индекс с какого нужно брать данные из src
        // dest - где будет результат
        // destPos - индекс с какого нужно вставлять в dest
        // length - сколько данных брать из src
//        System.arraycopy(a, 3, b, 0, 3);
    }
}