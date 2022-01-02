/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
