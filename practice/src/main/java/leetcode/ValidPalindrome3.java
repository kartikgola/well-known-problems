/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class ValidPalindrome3 {

    public boolean isValidPalindrome(String s, int p) {
        int n = s.length();
        // dp[i][j] = Length of longest palindromic subsequence in s[i..j]
        int[][] dp = new int[n][n];

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n-k; ++i) {
                int j = i+k;
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
            }
        }

        return dp[0][n-1] >= n-p;
    }
}
