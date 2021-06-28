/*
 * Author: Kartik Gola
 * Date: 1/17/21, 4:33 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/count-sorted-vowel-strings/
 */

package leetcode;

public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        final int K = 5;
        int[][] dp = new int[n+1][K];
        for (int i = 0; i <= n; ++i) {
            for (int j = K-1; j > -1; --j) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + (j < K-1 ? dp[i][j+1] : 0);
                }
            }
        }
        return dp[n][0];
    }

}
