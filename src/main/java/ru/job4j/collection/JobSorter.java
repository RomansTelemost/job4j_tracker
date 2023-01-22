package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Abort server", 4),
                new Job("Abort server", 1),
                new Job("Abort server", 2)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        Collections.sort(jobs, new SortByJobName());
        System.out.println(jobs);
        jobs.sort(new SortDescByJobName());
        System.out.println(jobs);
        Collections.sort(jobs, new SortDescByJobName().thenComparing(new SortDescByJobPriority()));
        System.out.println(jobs);
        Comparator<Job> comb = new JobDescByNameLn()
                .thenComparing(new SortDescByJobName())
                .thenComparing(new SortDescByJobPriority());
        Collections.sort(jobs, comb);
    }
}
