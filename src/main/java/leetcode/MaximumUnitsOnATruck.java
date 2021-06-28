/*
 * Author: Kartik Gola
 * Date: 6/15/21, 11:52 AM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/maximum-units-on-a-truck/
 */

package leetcode;

import java.util.Arrays;

public class MaximumUnitsOnATruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (e1, e2) -> e2[1] - e1[1]);
        int loaded = 0, units = 0;
        for (int i = 0; i < boxTypes.length && loaded != truckSize; ++i) {
            int boxes = Math.min(truckSize - loaded, boxTypes[i][0]);
            units += boxes * boxTypes[i][1];
            loaded += boxes;
        }
        return units;
    }
}
