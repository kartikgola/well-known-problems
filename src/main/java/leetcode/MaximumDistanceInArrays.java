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
        int maxDist = 0,
            minVal = arr.get(0).get(0),
            maxVal = arr.get(0).get(arr.get(0).size() - 1);

        for ( int i = 1; i < arr.size(); ++i ) {
            final Integer currentMin = arr.get(i).get(0),
                          currentMax = arr.get(i).get(arr.get(i).size() - 1);
            maxDist = Math.max(maxDist, Math.max(
                Math.abs(maxVal - currentMin),
                Math.abs(currentMax - minVal)
            ));
            // Values of min/max may be from same array but dist is always updated by taking values from current array
            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return maxDist;
    }
}
