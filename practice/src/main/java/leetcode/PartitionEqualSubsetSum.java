/*
 * Author: Kartik Gola
 * Date: 1/11/22, 11:19 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        sum /= 2;

        // algorithm = if we can form sum/2 using any combination of numbers in nums[], we can definitely form the other
        // half, because total sum of 2 halves is sum
        // dp[i][j] = can we form the sum 'j' using numbers in [0..i]
        // dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
        boolean[][] dp = new boolean[n][sum+1];

        for (int j = 0; j <= sum; ++j)
            dp[0][j] = nums[0] == j;

        for (int i = 0; i < n; ++i)
            dp[i][0] = false;

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (j - nums[i] > 0)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                else if (j - nums[i] == 0)
                    dp[i][j] = true;
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n-1][sum];
    }
}
