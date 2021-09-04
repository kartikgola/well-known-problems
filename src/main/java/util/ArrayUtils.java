/*
 * Author: Kartik Gola
 * Date: 6/27/21, 11:33 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package util;

import java.util.List;

public class ArrayUtils {

    public static class Bisect {

        // ------------------------Left Bisection-----------------------------
        public static int bisectLeft(int[] arr, int from, int to, int x) {
            int l = from, r = to-1;
            while (l < r) {
                int m = l+(r-l)/2;
                if (arr[m] >= x)
                    r = m-1;
                else
                    l = m+1;
            }
            if (l >= to)
                return l;
            return arr[l] < x ? l+1 : l;
        }

        public static int bisectLeft(int[] arr, int x) {
            return bisectLeft(arr, 0, arr.length, x);
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        public static <T> int bisectLeft(T[] arr, int from, int to, T x) {
            int l = from, r = to-1;
            while (l < r) {
                int m = l+(r-l)/2;
                if (((Comparable) arr[m]).compareTo(x) >= 0)
                    r = m-1;
                else
                    l = m+1;
            }
            if (l >= to)
                return l;
            return ((Comparable) arr[l]).compareTo(x) < 0 ? l+1 : l;
        }

        public static <T> int bisectLeft(T[] arr, T x) {
            return bisectLeft(arr, 0, arr.length, x);
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        public static <T> int bisectLeft(List<T> arr, int from, int to, T x) {
            int l = from, r = to-1;
            while (l < r) {
                int m = l+(r-l)/2;
                if (((Comparable)arr.get(m)).compareTo(x) >= 0)
                    r = m-1;
                else
                    l = m+1;
            }
            if (l >= to)
                return l;
            return ((Comparable) arr.get(l)).compareTo(x) < 0 ? l+1 : l;
        }

        public static <T> int bisectLeft(List<T> arr, T x) {
            return bisectLeft(arr, 0, arr.size(), x);
        }


        // ------------------------Right Bisection-----------------------------
        public static int bisectRight(int[] arr, int x) {
            return bisectRight(arr, 0, arr.length, x);
        }

        public static int bisectRight(int[] arr, int from, int to, int x) {
            int l = from, r = to-1;
            while (l < r) {
                int m = l+(r-l)/2;
                if (arr[m] <= x)
                    l = m+1;
                else
                    r = m-1;
            }
            if (l >= to)
                return l;
            return arr[l] <= x ? l+1 : l;
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        public static <T> int bisectRight(T[] arr, int from, int to, T x) {
            int l = from, r = to-1;
            while (l < r) {
                int m = l+(r-l)/2;
                if (((Comparable) arr[m]).compareTo(x) <= 0)
                    l = m+1;
                else
                    r = m-1;
            }
            if (l >= to)
                return l;
            return ((Comparable) arr[l]).compareTo(x) <= 0 ? l+1 : l;
        }

        public static <T> int bisectRight(T[] arr, T x) {
            return bisectRight(arr, 0, arr.length, x);
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        public static <T> int bisectRight(List<T> arr, int from, int to, T x) {
            int l = from, r = to-1;
            while (l < r) {
                int m = l+(r-l)/2;
                if (((Comparable) arr.get(m)).compareTo(x) <= 0)
                    l = m+1;
                else
                    r = m-1;
            }
            if (l >= to)
                return l;
            return ((Comparable) arr.get(l)).compareTo(x) <= 0 ? l+1 : l;
        }

        public static <T> int bisectRight(List<T> arr, T x) {
            return bisectRight(arr, 0, arr.size(), x);
        }

    }
}