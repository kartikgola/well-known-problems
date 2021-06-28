/*
 * Author: Kartik Gola
 * Date: 03/07/20, 12:42 AM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;

        if ( x > y )
            return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = x;
        while ( lo <= hi ) {
            int px = lo + (hi - lo) / 2;
            int py = ((x + y + 1) / 2) - px;

            int x1 = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            int x2 = px == x ? Integer.MAX_VALUE : nums1[px];

            int y1 = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];
            int y2 = py == y ? Integer.MAX_VALUE : nums2[py];

            if ( x1 <= y2 && y1 <= x2 ) {
                if ( (x + y) % 2 == 0 )
                    return ((double) Math.max(x1, y1) + Math.min(x2, y2)) / 2;
                else
                    return (double) Math.max(x1, y1);
            } else if ( x1 > y2 ) {
                hi = px - 1;
            } else {
                lo = px + 1;
            }
        }

        return -1;
    }

}
