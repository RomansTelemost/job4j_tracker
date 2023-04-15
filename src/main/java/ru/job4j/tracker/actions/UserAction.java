package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Store;

public interface UserAction {

    String ASK_NAME_MESSAGE = "Enter name: ";
    String ASK_ID_MESSAGE = "Enter id: ";

    String name();

    boolean execute(Input input, Store tracker);
}
