/*
 * Author: Kartik Gola
 * Date: 24/07/20, 8:38 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */

package practice.leetcode;

class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while (l < r) {
            int m = l+(r-l)/2;
            if (nums[m] <= nums[r]) {
                r = m;
            } else {
                l = m+1;
            }
        }

        return nums[l];
    }
}
