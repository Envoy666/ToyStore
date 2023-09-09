package ru.gb.learn.provider;

import ru.gb.learn.toy.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyListGenerator implements DataProvider {
    @Override
    public List<Toy> getToyList() {
        // в теории, генерация значений кейса, веса и количества влияют друг на друга,
        // но в данном конкретном случае не вижу смысла создавать отдельный экземпляр под каждую задачу
        Random random = new Random();
        String[] names = {"Teddy Bear", "Robot", "Barbie", "Jet", "Constructor", "Soccer ball"};
        int capacity = 10;
        List<Toy> toyList = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++)
            toyList.add(new Toy(names[random.nextInt()], random.nextFloat(), random.nextInt(11)));
        return toyList;
    }
}
