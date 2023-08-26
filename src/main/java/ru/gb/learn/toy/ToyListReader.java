package ru.gb.learn.toy;

import ru.gb.learn.file.FileReader;

import java.util.List;

public class ToyListReader implements DataProvider{
    @Override
    public List<Toy> getToyList() {
        return FileReader.read("test.json");
    }
}
