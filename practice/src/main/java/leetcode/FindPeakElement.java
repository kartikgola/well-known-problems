/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l+(r-l)/2;
            if (m == 0 || m == nums.length-1) {
                return l == r ? m : (nums[l] > nums[r] ? l : r);
            } else {
                if (nums[m] > nums[m-1] && nums[m] > nums[m+1]) {
                    return m;
                } else if (nums[m] < nums[m+1]) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
        }
        return -1;
    }
}
