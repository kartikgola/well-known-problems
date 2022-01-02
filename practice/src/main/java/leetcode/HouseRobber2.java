/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class HouseRobber2 {

    private int rob(int[] nums, int i, int end, Integer[] dp) {
        if (i >= end)
            return 0;
        if (dp[i] != null)
            return dp[i];
        return dp[i] = Math.max(nums[i] + rob(nums, i+2, end, dp), rob(nums, i+1, end, dp));
    }

    // For a given i, we can return max{ nums[i] + f(i+2), f(i+1) }
    // Also, since the houses are in circle, we can either rob in interval [0, n-2] or [1, n-1]
    public int rob(int[] nums) {
        final int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(rob(nums, 0, n-1, new Integer[n]), rob(nums, 1, n, new Integer[n]));
    }

}
