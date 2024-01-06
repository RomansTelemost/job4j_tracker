package ru.job4j.tracker.actions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;
import ru.job4j.tracker.repository.MemTracker;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {

    @Test
    public void whenAddOneItemThenReturnOneItem() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item searchItem = new Item("Search item");

        tracker.add(searchItem);
        FindByNameAction find = new FindByNameAction(out);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(searchItem.getName());

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        Assertions.assertThat(out.toString())
                .isEqualTo("=== Find items by name ===" + ln + searchItem + ln);
    }

    @Test
    public void whenAddManyItemsWithSameNameThenReturnManyItems() {
        Output out = new StubOutput();
        Store store = new MemTracker();
        Item searchItem1 = new Item("Search item 1");
        Item searchItem2 = new Item("Search item 1");
        Item searchItem3 = new Item("Search item 1");
        Item searchItem4 = new Item("Search item 2");
        store.add(searchItem1);
        store.add(searchItem2);
        store.add(searchItem3);
        store.add(searchItem4);
        FindByNameAction find = new FindByNameAction(out);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(searchItem1.getName());

        find.execute(input, store);

        String ln = System.lineSeparator();
        Assertions.assertThat(out.toString())
                .isEqualTo("=== Find items by name ===" + ln + searchItem1
                        + ln + searchItem2
                        + ln + searchItem3
                        + ln);
    }
}