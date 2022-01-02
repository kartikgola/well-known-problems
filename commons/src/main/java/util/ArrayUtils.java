/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:45 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package util;import java.util.List;

public class ArrayUtils {

    public static class Bisect {

        // ------------------------Left Bisection-----------------------------
        // Returns the least index at which x should be inserted, to maintain sorted order
        // May return an index == size of array
        // Same as python's bisect_left
        public static int bisectLeft(int[] arr, int from, int to, int x) {
            int l = from, r = to-1;
            while (l < r) {
                int m = l+(r-l)/2;
                // Predicate = arr[m] is greater than equal to x
                if (arr[m] >= x)
                    r = m;
                else
                    l = m+1;
            }
            // l is now least index that satisfies predicate
            if (l >= to)
                return l;
            // check if l actually satisfies predicate; if not, return l+1
            return arr[l] >= x ? l : l+1;
        }

        public static int bisectLeft(int[] arr, int x) {
            return bisectLeft(arr, 0, arr.length, x);
        }

        public static int bisectLeft(List<Integer> arr, int from, int to, Integer x) {
            int l = from, r = to-1;
            while (l < r) {
                int m = l+(r-l)/2;
                if (((Comparable)arr.get(m)).compareTo(x) >= 0)
                    r = m;
                else
                    l = m+1;
            }
            if (l >= to)
                return l;
            return ((Comparable) arr.get(l)).compareTo(x) >= 0 ? l : l+1;
        }

        public static int bisectLeft(List<Integer> arr, Integer x) {
            return bisectLeft(arr, 0, arr.size(), x);
        }

        // ------------------------Right Bisection-----------------------------
        // Returns the highest index at which x should be inserted, to maintain sorted order
        // May return an index == size of array
        // Same as python's bisect_right
        public static int bisectRight(int[] arr, int x) {
            return bisectRight(arr, 0, arr.length, x);
        }

        public static int bisectRight(int[] arr, int from, int to, int x) {
            int l = from, r = to-1;
            while (l < r) {
                int m = l+(r-l)/2;
                // Predicate = arr[m] is greater than equal to x+1
                if (arr[m] >= x+1)
                    r = m;
                else
                    l = m+1;
            }
            // l is now least index that satisfies predicate
            if (l >= to)
                return l;
            // check if l actually satisfies predicate; if not, return l+1
            return arr[l] >= x+1 ? l : l+1;
        }

        public static int bisectRight(List<Integer> arr, int from, int to, Integer x) {
            int l = from, r = to-1;
            while (l < r) {
                int m = l+(r-l)/2;
                if (((Comparable) arr.get(m)).compareTo(x+1) >= 0)
                    r = m;
                else
                    l = m+1;
            }
            if (l >= to)
                return l;
            return ((Comparable) arr.get(l)).compareTo(x+1) >= 0 ? l : l+1;
        }

        public static int bisectRight(List<Integer> arr, Integer x) {
            return bisectRight(arr, 0, arr.size(), x);
        }

    }
}