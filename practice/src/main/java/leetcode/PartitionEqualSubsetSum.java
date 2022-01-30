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

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num: nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        int half = sum/2;

        // dp[i][j] = Can we form sum j using numbers in [i,n-1]
        // goal is to find dp[0][half]
        // at every stage for ith number, we can choose to include it or not
        // dp[i][j] = dp[i+1][j] || dp[i][j-nums[i]]
        final int n = nums.length;
        boolean[][] dp = new boolean[n][half+1];

        for (int j = 1; j <= half; ++j)
            dp[n-1][j] = nums[n-1] == j;

        for (int i = 0; i < n; ++i)
            dp[i][0] = true;

        for (int i = n-2; i >= 0; --i) {
            for (int j = 1; j <= half; ++j) {
                if (j - nums[i] >= 0)
                    dp[i][j] = dp[i+1][j] || dp[i+1][j-nums[i]];
                else
                    dp[i][j] = dp[i+1][j];
            }
        }

        return dp[0][half];
    }

    private boolean f(int[] nums, int i, int sum, Boolean[][] memo) {
        if (i >= nums.length || sum < 0)
            return false;
        if (memo[i][sum] != null)
            return memo[i][sum];

        // f(i, sum) = f(i+1, sum-nums[i]) || f(i+1, sum)
        // f(i, sum) = can we form 'sum' picking numbers in [i, n-1]
        if (nums[i] == sum)
            return true;
        else if (sum - nums[i] > 0)
            return memo[i][sum] = f(nums, i+1, sum, memo) || f(nums, i+1, sum - nums[i], memo);
        else
            return memo[i][sum] = f(nums, i+1, sum, memo);
    }

    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int num: nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        return f(nums, 0, sum/2, new Boolean[nums.length][sum/2+1]);
    }
}
