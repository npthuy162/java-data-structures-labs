package com.mycompany.datastructures;

import java.util.Comparator;

public class SimpleSorters {

    // Optimized Bubble Sort
    public static <K> void bubbleSort(K[] S, Comparator<? super K> comp) {
        int n = S.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (comp.compare(S[j], S[j + 1]) > 0) {
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    // Insertion Sort
    public static <K> void insertionSort(K[] S, Comparator<? super K> comp) {
        int n = S.length;

        for (int i = 1; i < n; i++) {
            K cur = S[i];
            int j = i - 1;

            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            S[j + 1] = cur;
        }
    }
}

