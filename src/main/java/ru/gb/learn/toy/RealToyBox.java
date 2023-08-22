package ru.gb.learn.toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RealToyBox implements ToyBox {

    private final Random random = new Random();
    private final List<Toy> toyList = new ArrayList<>();

    public void put(Toy toy) {
        toyList.add(toy);
    }

    @Override
    public Toy get() {
        if (toyList.isEmpty()) return null;
        return toyList.remove(random.nextInt(toyList.size()));
    }

    @Override
    public boolean isReady() {
        return !toyList.isEmpty();
    }
}