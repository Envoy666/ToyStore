package ru.gb.learn.toy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Toy {
    final int id;
    final String name;
    @Setter
    float weight;
}
