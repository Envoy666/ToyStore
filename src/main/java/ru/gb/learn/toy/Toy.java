package ru.gb.learn.toy;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Toy {
    private String name;
    private float weight;
    @Setter
    private int amount;
}
