package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;

public class CreateAction implements UserAction {

    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create a new Item ===");
        String name = input.askStr(ASK_NAME_MESSAGE);
        Item item = new Item(name);
        if (null != tracker.add(item)) {
            out.println("Добавленная заявка: " + item);
            return true;
        }
        out.println("Ошибка добавления заявки: " + item);
        return false;
    }

    @Override
    public String toString() {
        return name();
    }
}
