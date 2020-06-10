/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        final int m = A.length;
        final int n = B.length;
        int[][] dp = new int[m + 1][n + 1];

        for ( int i = 1; i <= m; ++i ) {
            for ( int j = 1; j <= n; ++j ) {
                if ( A[i - 1] == B[j - 1] )
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

}
