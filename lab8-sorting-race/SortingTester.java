package com.mycompany.sortingracelab8;

import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {

        int[] sizes = {
            1000, 5000, 10000, 25000, 50000, 100000
        };

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {

            System.out.println(
                    "\n--- Testing for array size n = " + n + " ---");

            System.out.println("Average Case:");
            runAndTimeAllSorts(generateRandomArray(n));

            System.out.println("Best Case:");
            runAndTimeAllSorts(generateSortedArray(n));

            System.out.println("Worst Case:");
            runAndTimeAllSorts(generateReverseSortedArray(n));
        }
    }

    public static void runAndTimeAllSorts(int[] original) {

        int[] selection = original.clone();
        int[] insertion = original.clone();
        int[] merge = original.clone();

        long start;
        long end;

        // Selection Sort
        start = System.nanoTime();
        SortingAlgorithms.selectionSort(selection);
        end = System.nanoTime();

        System.out.printf(
                "Selection Sort: %.3f ms%n",
                (end - start) / 1_000_000.0);

        // Insertion Sort
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(insertion);
        end = System.nanoTime();

        System.out.printf(
                "Insertion Sort: %.3f ms%n",
                (end - start) / 1_000_000.0);

        // Merge Sort
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(merge);
        end = System.nanoTime();

        System.out.printf(
                "Merge Sort: %.3f ms%n",
                (end - start) / 1_000_000.0);
    }

    public static int[] generateRandomArray(int size) {

        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }

        return arr;
    }

    public static int[] generateSortedArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }

        return arr;
    }
}
