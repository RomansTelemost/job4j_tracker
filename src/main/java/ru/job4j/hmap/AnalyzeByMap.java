package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double scoreSum = 0D;
        for (Pupil pupil : pupils) {
            int scoreSumByPupil = 0;
            for (Subject subject : pupil.subjects()) {
                scoreSumByPupil += subject.score();
            }
            scoreSum += (double) scoreSumByPupil / pupil.subjects().size();
        }
        return scoreSum / pupils.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int scoreSumByPupil = 0;
            for (Subject subject : pupil.subjects()) {
                scoreSumByPupil += subject.score();
            }
            list.add(new Label(pupil.name(), scoreSumByPupil / pupil.subjects().size()));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.name(), 0) + subject.score();
                map.put(subject.name(), score);
            }
        }
        List<Label> list = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            list.add(new Label(pair.getKey(), pair.getValue() / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        SortedSet<Label> list = new TreeSet<>();
        for (Pupil pupil : pupils) {
            int scoreSumByPupil = 0;
            for (Subject subject : pupil.subjects()) {
                scoreSumByPupil += subject.score();
            }
            list.add(new Label(pupil.name(), scoreSumByPupil));
        }
        return list.last();
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.name(), 0) + subject.score();
                map.put(subject.name(), score);
            }
        }
        SortedSet<Label> list = new TreeSet<>();
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            list.add(new Label(pair.getKey(), pair.getValue()));
        }
        return list.last();
    }
}
