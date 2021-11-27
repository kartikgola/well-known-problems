/*
 * Author: Kartik Gola
 * Date: 11/27/21, 6:34 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int prev = 0;
        int removed = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] > intervals[i][1]) {
                    prev = i;
                }
                ++removed;
            } else {
                prev = i;
            }
        }
        return removed;
    }
}
