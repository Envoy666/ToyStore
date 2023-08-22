package ru.gb.learn.toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyListGenerator implements DataProvider {
    @Override
    public List<Toy> getToyList() {
        Random random = new Random();
        int capacity = 10;
        List<Toy> toyList = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            toyList.add(
                    switch (random.nextInt(6)) {
                        case 0 -> new Toy(0, "Teddy Bear", 1);
                        case 1 -> new Toy(1, "Terminator", 1);
                        case 2 -> new Toy(2, "Barbie", 1);
                        case 3 -> new Toy(3, "Jet", 1);
                        case 4 -> new Toy(4, "Constructor", 1);
                        case 5 -> new Toy(5, "Soccer ball", 1);
                        default -> null;
                    }
            );
        }
        return toyList;
    }
}
