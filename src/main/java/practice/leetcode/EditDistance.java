/*
 * Author: Kartik Gola
 * Date: 10/02/2021, 20:25
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/edit-distance/
 */

package practice.leetcode;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for ( int j = 0; j <= n; ++j )
            dp[0][j] = j;

        for ( int i = 0; i <= m; ++i )
            dp[i][0] = i;

        for ( int i = 1; i <= m; ++i ) {
            for ( int j = 1; j <= n; ++j ) {
                if ( word1.charAt(i - 1) == word2.charAt(j - 1) ) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min( dp[i - 1][j - 1], Math.min( dp[i - 1][j], dp[i][j - 1] ) );
                }
            }
        }

        return dp[m][n];
    }
}
