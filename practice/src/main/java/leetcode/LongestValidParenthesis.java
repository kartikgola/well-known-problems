/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    // x()
                    // --i
                    dp[i] = (i-2 >= 0 ? dp[i-2] : 0) + 2;
                } else if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    // x(())
                    // ----i
                    dp[i] = dp[i-1] + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }
}
