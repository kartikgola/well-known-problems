/*
 * Author: Kartik Gola
 * Date: 9/19/21, 10:08 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class DistinctSubsequences {

    Integer[][] dp;

    private int f(String s, int i, String t, int j) {
        if (j == t.length())
            return 1;
        // dp[i][j] = no. of subsequences of string t[j..n] in the string s[i..n]
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = 0;
        for (int k = i; k < s.length()-(t.length()-j-1); ++k) {
            if (s.charAt(k) == t.charAt(j)) {
                ans += f(s, k+1, t, j+1);
            }
        }
        return dp[i][j] = ans;
    }

    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return f(s, 0, t, 0);
    }

    public int numDistinct2(String s, String t) {
        int n = t.length();
        int m = s.length();
        int[][] dp = new int[n+1][m+1];

        for (int j = 0; j <= m; ++j)
            dp[0][j] = 1;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[n][m];
    }
}
