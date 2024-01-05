package ru.job4j.lombok;

import lombok.*;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class BirdData {
    @Getter
    @Setter
    @NonNull
    private String color;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private int wingspan;
}
