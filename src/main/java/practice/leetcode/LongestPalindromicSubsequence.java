/*
 * Author: Kartik Gola
 * Date: 10/11/21, 10:39 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        final int n = s.length();
        // dp[i][j] = longest palindromic subsequence in s[i..j]
        int[][] dp = new int[n][n];

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n - k; ++i) {
                int j = i + k;
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    // If ends are same, pick the LPS in middle part
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        // Else, pick the max LPS from -1 end OR +1 start
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
