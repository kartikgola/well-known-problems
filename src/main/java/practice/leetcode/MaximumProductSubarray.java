/*
 * Author: Kartik Gola
 * Date: 9/20/21, 1:39 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            int newMax = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            int newMin = Math.min(nums[i], Math.min(max*nums[i], min*nums[i]));
            ans = Math.max(ans, newMax);
            max = newMax;
            min = newMin;
        }

        return ans;
    }
}
