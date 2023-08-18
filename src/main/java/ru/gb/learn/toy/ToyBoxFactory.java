package ru.gb.learn.toy;

import java.util.List;

public interface ToyBoxFactory {
    ToyBox createToyBox(List<Toy> toyList);
}
