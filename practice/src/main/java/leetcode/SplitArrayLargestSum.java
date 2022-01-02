/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; ++i)
            sum[i] += sum[i-1] + nums[i];

        // dp[i][j] = min. largest sum in nums[0..i] using j splits
        int[][] dp = new int[n][m];
        for (int[] d: dp)
            Arrays.fill(d, Integer.MAX_VALUE);

        // for 0 splits, dp[i][0] will just be sum[i]
        for (int i = 0; i < n; ++i)
            dp[i][0] = sum[i];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int k = 0; k < i; ++k) {
                    // dp[i][j] = min(dp[i][j], max(dp[k][j-1], sum[i]-sum[k]))
                    if (j-1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sum[i]-sum[k]));
                    }
                }
            }
        }

        return dp[n-1][m-1];
    }

    private boolean canSplit(int[] nums, int maxSum, int m) {
        int subArrays = 1;
        int currSum = 0;
        for (int num: nums) {
            currSum += num;
            if (currSum > maxSum) {
                currSum = num;
                subArrays++;
                if (subArrays > m)
                    return false;
            }
        }
        return true;
    }

    public int splitArray2(int[] nums, int m) {
        // left = maximum one element sum
        // right = sum of all nums
        int l = nums[0];
        int r = 0;
        for (int num: nums) {
            l = Math.max(l, num);
            r += num;
        }

        while (l < r) {
            int mid = l+(r-l)/2;
            if (canSplit(nums, mid, m)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }

        return l;
    }
}
