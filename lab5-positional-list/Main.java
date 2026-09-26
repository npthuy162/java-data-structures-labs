package com.mycompany.positionallist;

public class Main {

    public static void main(String[] args) {

        LinkedPositionalList<String> itinerary =
                new LinkedPositionalList<>();

        Position<String> paris =
                itinerary.addLast("Paris");

        Position<String> eiffel =
                itinerary.addLast("Eiffel Tower");

        itinerary.addLast("Louvre Museum");

        System.out.println("Original Itinerary:");

        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }

        itinerary.addAfter(eiffel, "Seine River Cruise");

        System.out.println("\nAfter adding a new stop:");

        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }

        System.out.println("\nFinal Itinerary (using for-each loop):");

        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }
    }
}
