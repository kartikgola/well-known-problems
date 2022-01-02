/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

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
