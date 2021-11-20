/*
 * Author: Kartik Gola
 * Date: 11/20/21, 11:49 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length-1;
        // 1,1,2,3,3 <= best case
        // 1,2,2,3,3 <= mid=2, and numbers from [0..mid-2] are odd, so we move window to the left
        // 1,1,2,2,3 <= mid=2, and numbers from [mid+2, n-1] are odd, so we move window to the right
        while (l < r) {
            int m = l+(r-l)/2;
            if (nums[m] == nums[m-1]) {
                if ((m-2-l+1) % 2 != 0) {
                    r = m-2;
                } else {
                    l = m+1;
                }
            } else if (nums[m] == nums[m+1]) {
                if ((m+2-l+1) % 2 != 0) {
                    l = m+2;
                } else {
                    r = m-1;
                }
            } else {
                return nums[m];
            }
        }
        return nums[l];
    }
}
