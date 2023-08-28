package ru.gb.learn.provider;

import ru.gb.learn.toy.Toy;

import java.util.List;

public interface DataProvider {
    List<Toy> getToyList();
}
