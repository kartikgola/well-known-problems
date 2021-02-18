/*
 * Author: Kartik Gola
 * Date: 22/01/2021, 01:13
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/rectangle-overlap/
 */

package leetcode;

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x11 = rec1[0], y11 = rec1[1],
            x12 = rec1[2], y12 = rec1[3],
            x21 = rec2[0], y21 = rec2[1],
            x22 = rec2[2], y22 = rec2[3];

        final long a1 = (long) (x12 - x11) * (y12 - y11);
        final long a2 = (long) (x22 - x21) * (y22 - y21);

        // If any rectangle has 0 area, there is no overlap
        if (a1 == 0 || a2 == 0)
            return false;

        // Check if any of the conditions will guarantee no overlap
        return x22 <= x11 || y21 >= y12 || x21 >= x12 || y22 <= y11 ? false : true;
    }
}