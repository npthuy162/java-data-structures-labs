package com.mycompany.iteratorinventory;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Magic Stone"));
        inventory.addItem(new Item("Wooden Staff"));
        inventory.addItem(new Item("Health Potion"));

        System.out.println("Before combining:");
        inventory.display();

        System.out.println();

        inventory.combineItems("Magic Stone", "Wooden Staff");

        System.out.println();

        System.out.println("After combining:");
        inventory.display();
    }
}
