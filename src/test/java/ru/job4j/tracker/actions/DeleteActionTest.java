package ru.job4j.tracker.actions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.job4j.tracker.*;
import ru.job4j.tracker.repository.MemTracker;

class DeleteActionTest {

    @Test
    public void whenRemoveDoesNotExistItemThenShowErrorMessage() {
        Output out = new StubOutput();
        Store store = new MemTracker();

        DeleteAction action = new DeleteAction(out);

        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askInt(Mockito.any(String.class))).thenReturn(1);

        action.execute(input, store);

        String ln = System.lineSeparator();

        Assertions.assertThat(out.toString()).isEqualTo("=== Delete item ==="
                + ln + "Ошибка удаления заявки."
                + ln);
    }

    @Test
    public void whenRemoveExistItemThenShowSuccessMessage() {
        Output out = new StubOutput();
        Store store = new MemTracker();
        store.add(new Item("Remove item"));

        DeleteAction action = new DeleteAction(out);

        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askInt(Mockito.any(String.class))).thenReturn(1);

        action.execute(input, store);

        String ln = System.lineSeparator();

        Assertions.assertThat(out.toString()).isEqualTo("=== Delete item ==="
                + ln + "Заявка удалена успешно."
                + ln);
    }

}