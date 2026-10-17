package com.mycompany.maxsubarraysum;

import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {

            System.out.println("\n--- Testing for array size n = " + n + " ---");

            int[] arr = generateRandomArrayWithNegatives(n);

            long start = System.nanoTime();
            int bruteResult = MaxSubarraySolver.bruteForceMaxSum(arr);
            long end = System.nanoTime();

            double bruteTime = (end - start) / 1_000_000.0;

            start = System.nanoTime();
            int kadaneResult = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            end = System.nanoTime();

            double kadaneTime = (end - start) / 1_000_000.0;

            System.out.printf("Brute Force: %.3f ms%n", bruteTime);
            System.out.printf("Kadane's Algorithm: %.3f ms%n", kadaneTime);

            System.out.println("Brute Force Max Sum: " + bruteResult);
            System.out.println("Kadane Max Sum: " + kadaneResult);
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {

        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(201) - 100;
        }

        return arr;
    }
}
