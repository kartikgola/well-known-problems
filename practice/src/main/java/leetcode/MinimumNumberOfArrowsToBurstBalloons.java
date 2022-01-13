/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
        int max = points[0][1]; // max point at which arrow can be shot at
        for ( int curr = 1; curr < n; ++curr ) {
            if ( points[curr][0] > max ) { // current start lies outside
                max = points[curr][1];
                ++arrows;
            } else { // current start lies inside
                max = Math.min(max, points[curr][1]);
            }
        }

        return arrows;
    }

    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));

        int ans = 1;

        // denotes the inclusive-range in which balloon can be shot
        int min = points[0][0];
        int max = points[0][1];

        // [[1,6],[2,8],[7,12],[10,16]]
        // [1,6] => [1,6]
        // [1,6], [2,8] => [2,6]
        // [1,6], [2,8], [7,12] => [2,6], [7,12]
        // [1,6], [2,8], [7,12], [10,16] => [2,6], [10,12]

        for (int i = 1; i < points.length; ++i) {
            int cmin = points[i][0];
            int cmax = points[i][1];

            // if current minimum lies inside the range, update the range
            if (cmin >= min && cmin <= max) {
                min = Math.max(min, cmin);
                max = Math.min(max, cmax);
            } else {
                // otherwise, create new range and increment answer
                ans++;
                min = cmin;
                max = cmax;
            }
        }

        return ans;
    }
}
