package ru.gb.learn.box;

import ru.gb.learn.toy.Toy;

import java.util.*;


public class LootToyBox implements ToyBox {

    private final Random random = new Random();

    private final TreeMap<Float, Toy> toyMap = new TreeMap<>();
    private float totalWeight = 0;
    private int count = 10;

    @Override
    public void putAll(List<Toy> toyList) {
        for (Toy toy : toyList) put(toy);
    }

    @Override
    public void put(Toy newToy) {
        for (Map.Entry<Float, Toy> entry : toyMap.entrySet()) {
            Toy oldToy = entry.getValue();
            if (oldToy.getName().equals(newToy.getName())) {
                if (oldToy.getWeight() == newToy.getWeight()) return;
                float delta = newToy.getWeight() - oldToy.getWeight();
                Map<Float, Toy> subTreeMap = toyMap.tailMap(entry.getKey());
                reconnect(subTreeMap, delta);
                totalWeight += delta;
                return;
            }
        }
        toyMap.put(totalWeight, newToy);
        totalWeight += newToy.getWeight();
    }

    private void reconnect(Map<Float, Toy> subTreeMap, float delta) {
        // avoid java.util.ConcurrentModificationException
        Iterator<Map.Entry<Float, Toy>> iterator = subTreeMap.entrySet().iterator();
        List<Map.Entry<Float, Toy>> reconnectList = new ArrayList<>(subTreeMap.size());
        while (iterator.hasNext()) {
            reconnectList.add(iterator.next());
            iterator.remove();
        }
        for (Map.Entry<Float, Toy> rEntry : reconnectList) {
            toyMap.put(rEntry.getKey() + delta, rEntry.getValue());
        }
    }

    @Override
    public Toy get() {
        count--;
        return toyMap.floorEntry(random.nextFloat(totalWeight)).getValue();
    }

    @Override
    public boolean isReady() {
        return count != 0;
    }
}
