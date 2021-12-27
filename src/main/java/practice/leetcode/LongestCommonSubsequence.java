/*
 * Author: Kartik Gola
 * Date: 12/27/21, 11:48 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class LongestCommonSubsequence {

    private Integer[][] memo;

    private int f(String text1, int i, String text2, int j) {
        if (i >= text1.length() || j >= text2.length())
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];
        if (text1.charAt(i) == text2.charAt(j))
            memo[i][j] = 1 + f(text1, i+1, text2, j+1);
        else
            memo[i][j] = Math.max(f(text1, i, text2, j+1), f(text1, i+1, text2, j));
        return memo[i][j];
    }

    // Top-down solution
    public int longestCommonSubsequence(String text1, String text2) {
        this.memo = new Integer[text1.length()][text2.length()];
        return f(text1, 0, text2, 0);
    }

    // Bottom-up solution
    public int longestCommonSubsequence2(String text1, String text2) {
        final int m = text1.length();
        final int n = text2.length();

        // dp[i][j] = longest common subseq in text1[0..i] and text2[0..j]
        // goal is to find dp[m][n]
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }

    // Bottom-up solution 2
    // Although less intuitive, this is more "natural" conversion of top-down approach
    // because it starts from the base case of top-down => i = len(text1) and j = len(text2)
    public int longestCommonSubsequence3(String text1, String text2) {
        final int m = text1.length();
        final int n = text2.length();

        // dp[i][j] = longest common subseq in text1[i..m-1] and text2[j..n-1]
        // goal is to find dp[m-1][n-1]
        int[][] dp = new int[m+1][n+1];

        for (int i = m-1; i >= 0; --i) {
            for (int j = n-1; j >= 0; --j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}
