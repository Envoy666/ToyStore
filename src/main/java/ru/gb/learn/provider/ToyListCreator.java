package ru.gb.learn.provider;

import lombok.AllArgsConstructor;
import ru.gb.learn.toy.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

@AllArgsConstructor
public class ToyListCreator implements DataProvider {
    private static final Pattern namePattern = compile("\\w+");
    private static final Pattern weightPattern = compile("^-?\\d*\\.?\\d+$");
    private static final Pattern amountPattern = compile("^\\d+$");
    private Scanner scanner;

    private String input(String paramName, Pattern pattern) {
        System.out.println("Input toy " + paramName);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) return null;
            if (!pattern.matcher(input).matches()) {
                System.out.println("Incorrect " + paramName + " format");
                continue;
            }
            return input;
        }
    }

    @Override
    public List<Toy> getToyList() {
        List<Toy> toyList = new ArrayList<>();
        System.out.println("Enter toys data (enter \"exit\" to finish)");
        int id = 0;
        while (true) {
            String name = input("name", namePattern);
            if (name == null) return toyList;
            String weightStr = input("weight", weightPattern);
            if (weightStr == null) return toyList;
            float weight = Float.parseFloat(weightStr);
            String amountStr = input("amount", amountPattern);
            if (amountStr == null) return toyList;
            int amount = Integer.parseInt(amountStr);
            toyList.add(new Toy(name, weight, amount));
            id++;
            System.out.println(name + " is added. List size: " + id);
        }
    }
}
