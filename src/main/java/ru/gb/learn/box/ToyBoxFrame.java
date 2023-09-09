package ru.gb.learn.box;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class ToyBoxFrame {
    private Scanner scanner;

    public ToyBox getToyBox() {
        System.out.println("""
                Select toy box type:
                1. Real box (toys quantity and probabilities depends on what toys in what quantity are added)
                2. Loot box (unlimited quantity of each toy type. probabilities depends on weights)
                3. Draw box (limited quantity of each toy type. probabilities depends on weights)
                """);
        int option;
        while (true) {
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Incorrect input format. Try again");
                continue;
            }
            ToyBox toyBox = switch (option) {
                case 1 -> new RealToyBox();
                case 2 -> new LootToyBox();
                case 3 -> new DrawToyBox();
                default -> {
                    System.out.println("Incorrect option. Try again");
                    yield null;
                }
            };
            if (toyBox != null) return toyBox;
        }
    }
}