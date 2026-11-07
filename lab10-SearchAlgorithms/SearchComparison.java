package com.mycompany.searchalgorithms;

public class SearchComparison {

    // Linear Search
    public static int linearSearch(int[] arr, int key) {
        int comparisonCounter = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisonCounter++;

            if (arr[i] == key) {
                System.out.println("Comparisons: " + comparisonCounter);
                return i;
            }
        }

        System.out.println("Comparisons: " + comparisonCounter);
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int comparisonCounter = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisonCounter++;

            if (arr[mid] == key) {
                System.out.println("Comparisons: " + comparisonCounter);
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Comparisons: " + comparisonCounter);
        return -1;
    }

    public static void main(String[] args) {
        int[] unsortedData = {22, 8, 12, 1, 9, 30, 4, 15};
        int[] sortedData = {1, 4, 8, 9, 12, 15, 22, 30};

        System.out.println("--- Lab 1: Search Algorithm Implementation ---");

        System.out.println("\nLinear Search (Unsorted):");
        System.out.println("Find 9: Index " + linearSearch(unsortedData, 9));
        System.out.println("Find 3: Index " + linearSearch(unsortedData, 3));

        System.out.println("\nBinary Search (Sorted):");
        System.out.println("Find 9: Index " + binarySearch(sortedData, 9));
        System.out.println("Find 3: Index " + binarySearch(sortedData, 3));
        System.out.println("Find 30: Index " + binarySearch(sortedData, 30));

        System.out.println("\nComparison Test (Find 30):");

        System.out.println("Linear Search:");
        linearSearch(sortedData, 30);

        System.out.println("Binary Search:");
        binarySearch(sortedData, 30);
    }
}
