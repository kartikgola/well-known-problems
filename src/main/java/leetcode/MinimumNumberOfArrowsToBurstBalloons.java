/*
 * Author: Kartik Gola
 * Date: 10/10/2020, 13:48
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */

package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        final int n = points.length;
        if ( n == 0 ) return 0;
        Arrays.sort(points, Comparator.comparingInt((int[] a) -> a[0]));

        int arrows = 1;
        int x = points[0][1]; // point at which arrow is shot
        for ( int curr = 1; curr < n; ++curr ) {
            if ( points[curr][0] > x ) { // current start lies outside
                x = points[curr][1];
                ++arrows;
            } else { // current start lies inside
                x = Math.min(x, points[curr][1]);
            }
        }

        return arrows;
    }
}
