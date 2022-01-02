/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    // Greedy solution / O(nlogn + n)
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int prev = 0;
        int removed = 0;
        for (int i = 1; i < intervals.length; ++i) {
            // check for prev and current overlap
            if (intervals[prev][1] > intervals[i][0]) {
                // prev will be removed only if it ends after current interval
                // that is, we are trying to "keep" intervals which are smaller
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

    public boolean isOverlapping(int[] a, int[] b) {
        return !(a[1] <= b[0] || a[0] >= b[1]);
    }

    // DP solution / O(nlogn + n^2)
    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(intv -> intv[0]));
        final int n = intervals.length;

        // dp[i] = max no of intervals that can be "included" when considering ith interval and some/all in intervals[0..i-1]
        // in other words, dp[i] = max length of intervals that can be included if we have to to include ith interval
        int ans = 1;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; ++i) {
            int max = 0;
            for (int j = 0; j < i; ++j) {
                if (!isOverlapping(intervals[j], intervals[i])) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans, dp[i]);
        }

        return n - ans;
    }
}
