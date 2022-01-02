/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class MinimumWindowSubsequence {

    public String minWindow(String s1, String s2) {
        if (s2.length() > s1.length())
            return "";
        int m = s2.length();
        int n = s1.length();

        // dp[i][j] = k, is the furthest index such that s1[k,j] contains a subsequence of substring s2[0,j]
        int[][] dp = new int[m][n];
        for (int[] d: dp)
            Arrays.fill(d, -1);

        dp[0][0] = s2.charAt(0) == s1.charAt(0) ? 0 : -1;

        // Find subsequence of substring s2[0] inside s1[0..j]
        for (int j = 1; j < n; ++j)
            dp[0][j] = s2.charAt(0) == s1.charAt(j) ? j : dp[0][j-1];

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (s2.charAt(i) == s1.charAt(j))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i][j-1];
            }
        }

        // In the last row, find the minimum window in s1, containing s2
        int l = 0, r = s1.length();
        for (int j = 0; j < n; ++j) {
            if (dp[m-1][j] != -1) {
                if (j-dp[m-1][j]+1 < r-l+1) {
                    l = dp[m-1][j];
                    r = j;
                }
            }
        }

        if (r == s1.length())
            return "";
        return s1.substring(l, r+1);
    }
}
