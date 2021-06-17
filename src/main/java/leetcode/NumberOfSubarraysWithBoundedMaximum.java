/*
 * Author: Kartik Gola
 * Date: 6/17/21, 9:43 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
 */

package leetcode;

public class NumberOfSubarraysWithBoundedMaximum {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int prev = -1, valid = -1, ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= right) {
                if (nums[i] >= left)
                    valid = i;
                ans += valid != -1 ? valid-prev : 0;
            } else {
                prev = i;
                valid = -1;
            }
        }
        return ans;
    }
}
