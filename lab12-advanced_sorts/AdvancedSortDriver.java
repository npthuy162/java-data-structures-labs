package com.mycompany.datastructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AdvancedSortDriver {

    public static void main(String[] args) {

        Comparator<Integer> comp = Comparator.naturalOrder();

        int N = 100;
        Random rand = new Random();

        Integer[] arr1 = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = rand.nextInt(100);
        }

        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test: Random Array (N=100) ---");
        System.out.println("Original: " + Arrays.toString(arr1));

        AdvancedSorters.mergeSort(arr1, comp);
        System.out.println("\nMerge Sort: " + Arrays.toString(arr1));

        AdvancedSorters.quickSort(arr2, comp);
        System.out.println("\nQuick Sort: " + Arrays.toString(arr2));

        System.out.println("\nBoth sorts match: "
                + Arrays.equals(arr1, arr2));
    }
}
