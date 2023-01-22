package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LexSortTest {

    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task.",
                "2. Task.",
                "112. Task.",
                "0. Task."
        };
        String[] out = {
                "0. Task.",
                "1. Task.",
                "2. Task.",
                "2. Task.",
                "10. Task.",
                "112. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(out);
    }
}