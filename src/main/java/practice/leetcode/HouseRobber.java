/*
 * Author: Kartik Gola
 * Date: 14/10/2020, 23:04
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/house-robber/
 */

package practice.leetcode;

public class HouseRobber {

    private int rob(int[] nums, int i, Integer[] dp) {
        if (i >= nums.length)
            return 0;
        if (dp[i] != null)
            return dp[i];
        return dp[i] = Math.max(nums[i] + rob(nums, i+2, dp), rob(nums, i+1, dp));
    }

    public int rob(int[] nums) {
        return rob(nums, 0, new Integer[nums.length]);
    }
}
