package ru.job4j.tracker.actions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.job4j.tracker.*;

class CreateActionTest {

    @Test
    public void whenAddNewItemThenReturnThatItem() {
        Output out = new StubOutput();
        Store store = new MemTracker();

        CreateAction action = new CreateAction(out);

        String newItemName = "Add new item";

        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askStr(Mockito.any(String.class))).thenReturn(newItemName);

        action.execute(input, store);

        String ln = System.lineSeparator();

        Assertions.assertThat(out.toString()).isEqualTo("=== Create a new Item ==="
                + ln + "Добавленная заявка: " + store.findById(1)
                + ln);
    }
}