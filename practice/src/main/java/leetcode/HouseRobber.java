/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class HouseRobber {

    private int rob(int[] nums, int i, Integer[] dp) {
        if (i >= nums.length)
            return 0;
        if (dp[i] != null)
            return dp[i];
        return dp[i] = Math.max(nums[i] + rob(nums, i+2, dp), rob(nums, i+1, dp));
    }

    // For a given i, we can return max{ nums[i] + f(i+2), f(i+1) }
    public int rob(int[] nums) {
        return rob(nums, 0, new Integer[nums.length]);
    }

    public int rob2(int[] nums) {
        // dp[i] = max amount we can rob starting from ith house (may/may not including ith house)
        int[] dp = new int[nums.length+2];
        for (int i = nums.length-1; i >= 0; --i) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}
