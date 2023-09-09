package ru.gb.learn.box;

import ru.gb.learn.toy.Toy;

import java.util.List;

public interface ToyBox {
//    void put(Toy toy);

    void putAll(List<Toy> toyList);

    void put(Toy newToy);

    Toy get();

    boolean isReady();
}
