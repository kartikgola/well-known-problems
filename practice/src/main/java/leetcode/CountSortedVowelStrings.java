/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
