/*
 * Author: Kartik Gola
 * Date: 4/2/21, 9:32 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package algorithms.sorting;

public class MergeSort {

    private void merge(int[] arr, int lo, int pos, int hi) {
        int[] left = new int[pos - lo + 1];
        int[] right = new int[hi - pos];
        System.arraycopy(arr, lo, left, 0, left.length);
        System.arraycopy(arr, pos + 1, right, 0, right.length);
        for ( int i = 0, j = 0, k = lo; i < left.length || j < right.length; ++k ) {
            if ( i < left.length && j < right.length ) {
                if ( left[i] <= right[j] ) {
                    arr[k] = left[i++];
                } else {
                    arr[k] = right[j++];
                }
            } else if ( i < left.length ) {
                arr[k] = left[i++];
            } else {
                arr[k] = right[j++];
            }
        }
    }

    private void mergeSort(int[] arr, int lo, int hi) {
        if ( lo < hi ) {
            int pos = lo + (hi - lo) / 2;
            mergeSort(arr, lo, pos);
            mergeSort(arr, pos + 1, hi);
            merge(arr, lo, pos, hi);
        }
    }

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
}
