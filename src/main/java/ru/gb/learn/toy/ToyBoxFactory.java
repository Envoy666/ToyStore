package ru.gb.learn.toy;

import ru.gb.learn.box.ToyBox;

import java.util.List;

public interface ToyBoxFactory {
    ToyBox createToyBox(List<Toy> toyList);
}
