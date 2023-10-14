package ru.job4j.tracker.actions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.job4j.tracker.*;

class FindByIdActionTest {

    @Test
    public void whenStoreDoesNotContainItem() {
        Output output = new StubOutput();
        Store store = new MemTracker();

        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askInt(Mockito.any(String.class))).thenReturn(1);

        FindByIdAction action = new FindByIdAction(output);
        action.execute(input, store);

        String ln = System.lineSeparator();

        Assertions.assertThat(output.toString()).isEqualTo("=== Find item by id ==="
                + ln + "Заявка с введенным id: " + 1 + " не найдена." + ln);
    }
    
    @Test
    public void whenStoreContainsSearchItem() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item searchItem1 = new Item("Search item 1");
        store.add(searchItem1);

        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askInt(Mockito.any(String.class))).thenReturn(1);

        FindByIdAction action = new FindByIdAction(output);
        action.execute(input, store);

        String ln = System.lineSeparator();

        Assertions.assertThat(output.toString()).isEqualTo("=== Find item by id ==="
                + ln + searchItem1
                + ln);
    }
}