package ru.gb.learn.toy;

import java.util.List;

public interface ToyBox {
//    void put(Toy toy);

    void putAll(List<Toy> toyList);

    Toy get();

    boolean isReady();
}
