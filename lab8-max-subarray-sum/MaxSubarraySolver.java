package com.mycompany.maxsubarraysum;

public class MaxSubarraySolver {

    /**
     * Brute-force approach.
     * The outer loop runs n times.
     * The inner loop runs up to n times for each outer loop.
     * About n(n+1)/2 primitive operations are performed.
     * Therefore, the time complexity is O(n^2).
     */
    public static int bruteForceMaxSum(int[] arr) {
        int maxSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;

            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * Kadane's Algorithm.
     * This algorithm uses one loop through the array.
     * Each element is processed one time.
     * Therefore, the time complexity is O(n).
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
