package ru.gb.learn.box;

import ru.gb.learn.toy.Toy;

import java.util.*;


public class DrawToyBox implements ToyBox {
    private final Random random = new Random();

    private final TreeMap<Float, Toy> toyMap = new TreeMap<>();
    private float totalWeight = 0;

    @Override
    public void putAll(List<Toy> toyList) {
        for (Toy toy : toyList) put(toy);
    }

    @Override
    public void put(Toy newToy) {
        for (Map.Entry<Float, Toy> entry : toyMap.entrySet()) {
            Toy oldToy = entry.getValue();
            if (oldToy.getName().equals(newToy.getName())) {
                oldToy.setAmount(newToy.getAmount());
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

    @Override
    public Toy get() {
        Map.Entry<Float, Toy> entry = toyMap.floorEntry(random.nextFloat(totalWeight));
        Toy toy = entry.getValue();
        toy.setAmount(toy.getAmount() - 1);
        if (toy.getAmount() == 0) {
            float delta = -toy.getWeight();
            Map<Float, Toy> subTreeMap = toyMap.tailMap(entry.getKey(), false);
            toyMap.remove(entry.getKey());
            reconnect(subTreeMap, delta);
        }
        return toy;
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
    public boolean isReady() {
        return !toyMap.isEmpty();
    }
}
