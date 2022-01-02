/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        // dp[i] = length of LIS ending at nums[i]
        int[] dp = new int[nums.length];
        // ct[i] = count of (number of) LIS ending at nums[i]
        int[] ct = new int[nums.length];
        int maxLen = 1;
        int maxCount = 0;
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = ct[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (1+dp[j] > dp[i]) {
                        dp[i] = 1+dp[j];
                        ct[i] = ct[j];
                    } else if (1+dp[j] == dp[i]) {
                        ct[i] += ct[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxCount = ct[i];
            } else if (dp[i] == maxLen) {
                maxCount += ct[i];
            }
        }
        return maxCount;
    }
}
