package com.mycompany.iteratorinventory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {

    private final List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        System.out.println("Inventory:");

        for (Item item : items) {
            System.out.println("- " + item);
        }
    }

    public void combineItems(String name1, String name2) {

        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();

        while (iter.hasNext()) {
            Item current = iter.next();

            if (!found1 && current.getName().equals(name1)) {
                found1 = true;
                iter.remove();
            } else if (!found2 && current.getName().equals(name2)) {
                found2 = true;
                iter.remove();
            }
        }

        if (found1 && found2) {
            items.add(new Item("Magic Staff"));
            System.out.println(name1 + " and " + name2
                    + " combined into Magic Staff!");
        } else {
            System.out.println("Items could not be combined.");
        }
    }
}
