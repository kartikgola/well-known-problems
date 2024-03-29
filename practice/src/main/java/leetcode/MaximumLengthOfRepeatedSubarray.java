/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        final int m = nums1.length;
        final int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int ans = 0;

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                ans = Math.max(dp[i][j], ans);
            }
        }

        return ans;
    }
}
