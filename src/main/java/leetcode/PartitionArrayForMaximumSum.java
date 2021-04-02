/*
 * Author: Kartik Gola
 * Date: 4/2/21, 1:11 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/partition-array-for-maximum-sum/
 */

package leetcode;

public class PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] arr, int K) {
        final int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i) {
            // Maximum element in current window
            int winMax = arr[i];
            // Iterate from 'size' = 1 to K (only for all valid windows)
            for (int size = 1; size <= K && i - size >= -1; ++size) {
                winMax = Math.max(winMax, arr[i - size + 1]);
                // In case 'size' can cover all elements in [0, i], use dp[i-size] as 0
                dp[i] = Math.max(dp[i], (i - size >= 0 ? dp[i-size] : 0) + winMax * size);
            }
        }

        return dp[n-1];
    }
}
