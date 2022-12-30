package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindElTest {

    @Test
    void whenKeyGThenNotFound() {
        String[] strings = new String[2];
        strings[0] = "V";
        strings[1] = "D";
        String expected = "G";
        ElementNotFoundException exception = assertThrows(ElementNotFoundException.class,
                () -> {
            FindEl.indexOf(strings, expected);
        });
        assertThat(exception.getMessage()).isEqualTo("Элемент со ключом G не найден");
    }
}