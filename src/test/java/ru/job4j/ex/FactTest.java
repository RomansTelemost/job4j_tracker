package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {

    @Test
    public void whenParameterIs0ThenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    new Fact().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }

    @Test
    public void whenParameterIs5Then120() {
        int result = new Fact().calc(5);
        int expected = 120;
        assertThat(result).isEqualTo(expected);
    }
}