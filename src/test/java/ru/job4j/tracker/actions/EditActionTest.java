package ru.job4j.tracker.actions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.job4j.tracker.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EditActionTest {

    @Test
    public void whenStoreContainsItemThenEdit() {
        Output output = new StubOutput();
        Store store = new MemTracker();

        Item editItem = new Item("Edit item");
        store.add(editItem);

        String newItem = "New item";

        Input input = Mockito.mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(newItem);

        EditAction action = new EditAction(output);
        action.execute(input, store);

        String ln = System.lineSeparator();

        Assertions.assertThat(output.toString()).isEqualTo("=== Edit item ==="
                + ln + "Заявка изменена успешно." + ln);
        Assertions.assertThat(store.findByName(newItem)).isNotEmpty();
    }

    @Test
    public void whenStoreDoesNotContainsItem() {
        Output output = new StubOutput();
        Store store = new MemTracker();

        String newItem = "New item";

        Input input = Mockito.mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(newItem);

        EditAction action = new EditAction(output);
        action.execute(input, store);

        String ln = System.lineSeparator();

        Assertions.assertThat(output.toString()).isEqualTo("=== Edit item ==="
                + ln + "Ошибка замены заявки." + ln);
    }

}