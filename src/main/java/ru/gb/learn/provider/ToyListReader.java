package ru.gb.learn.provider;

import ru.gb.learn.file.FileReader;
import ru.gb.learn.toy.Toy;

import java.util.List;

public class ToyListReader implements DataProvider {
    @Override
    public List<Toy> getToyList() {
        return FileReader.read("test.json");
    }
}
