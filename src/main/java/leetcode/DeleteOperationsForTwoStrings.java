/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/delete-operation-for-two-strings/
 */

package leetcode;

public class DeleteOperationsForTwoStrings {

    public int minDistance(String word1, String word2) {
        final int m = word1.length(),
                  n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j == 0 ? 0 : dp[i][j-1] + 1;
                else if (j == 0)
                    dp[i][j] = dp[i-1][j] + 1;
                else if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m][n];
    }
}
