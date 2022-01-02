/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning2 {

    private int minCut(String s, int i, boolean[][] pd, Integer[] dp) {
        if (i >= s.length())
            return -1;
        // maximum cuts in a string of length n is (n-1)
        int ans = (s.length()-i)-1;
        if (dp[i] != null)
            return dp[i];
        for (int j = i; j < s.length(); ++j) {
            // Only if string[i..j] is palindrome, we can partition the remaining string
            if (pd[i][j]) {
                int sub = minCut(s, j+1, pd, dp);
                // -1 indicates that we've reached end
                // Example, minCut("a") = 0
                if (sub == -1) {
                    ans = Math.min(ans, 0);
                } else {
                    // Otherwise, add 1 to sub
                    ans = Math.min(ans, 1 + sub);
                }
            }
        }
        return dp[i] = ans;
    }

    public int minCut(String s) {
        boolean[][] pd = new boolean[s.length()][s.length()];
        for (int l = 0; l < s.length(); ++l) {
            for (int i = 0; i+l < s.length(); ++i) {
                int j = i+l;
                if (l == 0)
                    pd[i][j] = true;
                else
                    pd[i][j] = s.charAt(i) == s.charAt(j) && (l <= 1 || pd[i + 1][j - 1]);
            }
        }
        return minCut(s, 0, pd, new Integer[s.length()]);
    }
}
