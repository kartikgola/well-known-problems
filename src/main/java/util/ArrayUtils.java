/*
 * Author: Kartik Gola
 * Date: 6/27/21, 11:33 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package util;

import java.util.List;

public class ArrayUtils {

    public static class Bisect {

        public static int bisectLeft(List<Integer> arr, int value) {
            if (arr.isEmpty()) return 0;
            int l = 0, r = arr.size()-1;
            while (l < r) {
                int m = l + (r-l) / 2;
                if (arr.get(m) == value) {
                    while (m-1 > -1 && arr.get(m-1) == value) --m;
                    return m;
                } else if (arr.get(m) < value) l = m+1;
                else r = m-1;
            }
            return arr.get(l) < value ? l+1 : l;
        }

        public static int bisectLeft(int[] arr, int value) {
            if (arr.length == 0) return 0;
            int l = 0, r = arr.length-1;
            while (l < r) {
                int m = l + (r-l) / 2;
                if (arr[m] == value) {
                    while (m-1 > -1 && arr[m-1] == value) --m;
                    return m;
                } else if (arr[m] < value) l = m+1;
                else  r = m-1;
            }
            return arr[l] < value ? l+1 : l;
        }

        public static int bisectLeft(int[] arr, int lo, int hi, int value) {
            if (lo == hi) return -1;
            int l = 0, r = arr.length-1;
            while (l < r) {
                int m = l + (r-l) / 2;
                if (arr[m] == value) {
                    while (m-1 > -1 && arr[m-1] == value) --m;
                    return m;
                } else if (arr[m] < value) l = m+1;
                else  r = m-1;
            }
            return arr[l] < value ? l+1 : l;
        }

        public static int bisectRight(int[] arr, int value) {
            if (arr.length == 0) return 0;
            int l = 0, r = arr.length-1;
            while (l < r) {
                int m = l + (r-l) / 2;
                if (arr[m] == value) {
                    while (m+1 < arr.length && arr[m+1] == value) ++m;
                    return m+1;
                } else if (arr[m] < value) l = m+1;
                else r = m-1;
            }
            return arr[l] <= value ? l+1 : l;
        }

        public static int bisectRight(List<Integer> arr, int value) {
            if (arr.isEmpty())  return 0;
            int l = 0, r = arr.size()-1;
            while (l < r) {
                int m = l + (r-l) / 2;
                if (arr.get(m) == value) {
                    while (m+1 < arr.size() && arr.get(m+1) == value) ++m;
                    return m+1;
                } else if (arr.get(m) < value) l = m+1;
                else r = m-1;
            }
            return arr.get(l) <= value ? l+1 : l;
        }
    }
}
