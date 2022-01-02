/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class RemoveCoveredIntervals {

    private boolean covers(int[] a, int [] b) {
        return a[0] <= b[0] && a[1] >= b[1];
    }

    public int removeCoveredIntervals(int[][] intervals) {
        final int n = intervals.length;
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if ( a[0] - b[0] != 0 )
                return a[0] - b[0];
            return b[1] - a[1];
        });

        int p = -1;
        int removed = 0;
        for ( int i = 0; i < n; ++i ) {
            if ( p == -1 || !covers(intervals[p], intervals[i]) ) {
                p = i;
            } else {
                removed++;
            }
        }

        return n - removed;
    }
}
