/*
 * Author: Kartik Gola
 * Date: 10/16/21, 12:52 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    public int maxPoints(int[][] p) {
        if (p.length <= 2)
            return p.length;
        // For every pair of points, find the slope
        // Keep a count of points having a particular slope value
        // ans = max_count + 1
        int ans = 2;
        for (int i = 0; i < p.length; ++i) {
            Map<Double, Integer> map = new HashMap<>();
            int count = 0;
            for (int j = 0; j < p.length; ++j) {
                double slope = (double)(p[j][1]-p[i][1]) / (p[j][0]-p[i][0]);
                map.put(slope, map.getOrDefault(slope, 0)+1);
                count = Math.max(count, map.get(slope));
            }
            ans = Math.max(ans, count+1);
        }
        return ans;
    }
}
