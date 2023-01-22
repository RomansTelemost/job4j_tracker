package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNameAndPriority = new SortByJobName()
                .thenComparing(new SortByJobPriority());
        int rslIsGreater = cmpNameAndPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rslIsGreater).isGreaterThan(0);
        int rslIsLess = cmpNameAndPriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rslIsLess).isLessThan(0);
        int rslIsZero = cmpNameAndPriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 1)
        );
        assertThat(rslIsZero).isEqualTo(0);
    }

    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new SortDescByJobName()
                .thenComparing(new SortDescByJobPriority());
        int rslIsGreater = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rslIsGreater).isGreaterThan(0);
        int rslIsLess = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rslIsLess).isLessThan(0);
        int rslIsZero = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rslIsZero).isEqualTo(0);
    }

    @Test
    public void whenComparatorByDescNameAndPriority() {
        Comparator<Job> cmpDescNamePriority = new SortDescByJobName()
                .thenComparing(new SortByJobPriority());
        int rslIsLess = cmpDescNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rslIsLess).isLessThan(0);
        int rslIsGreater = cmpDescNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rslIsGreater).isGreaterThan(0);
        int rslIsZero = cmpDescNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rslIsZero).isEqualTo(0);
    }

    @Test
    public void whenComparatorByNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new SortByJobName()
                .thenComparing(new SortDescByJobPriority());
        int rslIsLess = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rslIsLess).isGreaterThan(0);
        int rslIsGreater = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rslIsGreater).isLessThan(0);
        int rslIsZero = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rslIsZero).isEqualTo(0);
    }

    @Test
    public void whenComparatorSortByName() {
        Comparator<Job> sortByJobName = new SortByJobName();
        int rsl = sortByJobName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorSortDescByName() {
        Comparator<Job> sortDescByName = new SortDescByJobName();
        int rsl = sortDescByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorSortByPriority() {
        Comparator<Job> sortByJobPriority = new SortByJobPriority();
        int rsl = sortByJobPriority.compare(
                new Job("Impl task", 3),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorSortDescByPriority() {
        Comparator<Job> sortDescByJobPriority = new SortDescByJobPriority();
        int rsl = sortDescByJobPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}