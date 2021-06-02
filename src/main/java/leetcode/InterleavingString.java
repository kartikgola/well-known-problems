/*
 * Author: Kartik Gola
 * Date: 6/2/21, 1:17 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/interleaving-string
 */

package leetcode;

public class InterleavingString {

    private String s1, s2, s3;
    private final Boolean[][] dp = new Boolean[101][101];

    private boolean f(int i, int j, int k) {
        // s1,s2,s3 are completely matched
        if (i == s1.length() && j == s2.length() && k == s3.length())
            return dp[i][j] = true;

        // case of s1 or s2 unmatched but s3 is completely matched
        if (k == s3.length())
            return dp[i][j] = false;

        if (dp[i][j] != null)
            return dp[i][j];

        char c1 = i < s1.length() ? s1.charAt(i) : '$',
             c2 = j < s2.length() ? s2.charAt(j) : '$',
             c3 = s3.charAt(k);

        if (c1 == c3 || c2 == c3) {
            if (c1 == c2)
                return dp[i][j] = f(i+1, j, k+1) || f(i, j+1, k+1);
            else if (c1 == c3)
                return dp[i][j] = f(i+1, j, k+1);
            else
                return dp[i][j] = f(i, j+1, k+1);
        }

        return dp[i][j] = false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return s1.length() + s2.length() == s3.length() && f(0, 0, 0);
    }
}
