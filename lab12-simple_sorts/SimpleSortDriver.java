package com.mycompany.datastructures;

import java.util.Arrays;
import java.util.Comparator;

public class SimpleSortDriver {

    public static void main(String[] args) {

        Comparator<Integer> comp = Comparator.naturalOrder();

        // Test 1: Unsorted Array
        Integer[] arr1 = {5, 1, 9, 3, 7, 6};
        Integer[] arr1Copy = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test 1: Unsorted Array ---");
        System.out.println("Original: " + Arrays.toString(arr1));

        SimpleSorters.bubbleSort(arr1, comp);
        System.out.println("Bubble Sort: " + Arrays.toString(arr1));

        SimpleSorters.insertionSort(arr1Copy, comp);
        System.out.println("Insertion Sort: " + Arrays.toString(arr1Copy));

        // Test 2: Reverse-Sorted Array
        Integer[] arr2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] arr2Copy = Arrays.copyOf(arr2, arr2.length);

        System.out.println("\n--- Test 2: Reverse-Sorted Array ---");
        System.out.println("Original: " + Arrays.toString(arr2));

        SimpleSorters.bubbleSort(arr2, comp);
        System.out.println("Bubble Sort: " + Arrays.toString(arr2));

        SimpleSorters.insertionSort(arr2Copy, comp);
        System.out.println("Insertion Sort: " + Arrays.toString(arr2Copy));

        // Test 3: Already-Sorted Array
        Integer[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] arr3Copy = Arrays.copyOf(arr3, arr3.length);

        System.out.println("\n--- Test 3: Already-Sorted Array ---");
        System.out.println("Original: " + Arrays.toString(arr3));

        SimpleSorters.bubbleSort(arr3, comp);
        System.out.println("Bubble Sort: " + Arrays.toString(arr3));

        SimpleSorters.insertionSort(arr3Copy, comp);
        System.out.println("Insertion Sort: " + Arrays.toString(arr3Copy));
    }
}

