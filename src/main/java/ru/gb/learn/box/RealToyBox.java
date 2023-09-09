package ru.gb.learn.box;

import ru.gb.learn.toy.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RealToyBox implements ToyBox {

    private final Random random = new Random();
    private final List<Toy> toyList = new ArrayList<>();

    @Override
    public void put(Toy toy) {
        toyList.add(toy);
    }

    @Override
    public void putAll(List<Toy> toyList) {
        this.toyList.addAll(toyList);
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
