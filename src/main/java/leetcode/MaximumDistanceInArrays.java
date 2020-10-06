/*
 * Author: Kartik Gola
 * Date: 03/10/2020, 13:06
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/maximum-distance-in-arrays/
 */

package leetcode;

import java.util.List;

public class MaximumDistanceInArrays {

    public int maxDistance(List<List<Integer>> arr) {
        int dist = 0,
            min = arr.get(0).get(0),
            max = arr.get(0).get(arr.get(0).size() - 1);

        for ( int i = 1; i < arr.size(); ++i ) {
            dist = Math.max(dist, Math.max(
                Math.abs(max - arr.get(i).get(0)),
                Math.abs(min - arr.get(i).get(arr.get(i).size() - 1))
            ));
            min = Math.min(min, arr.get(i).get(0));
            max = Math.max(max, arr.get(i).get(arr.get(i).size() - 1));
        }

        return dist;
    }
}
