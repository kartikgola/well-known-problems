/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package leetcode;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] grid) {
        final int m = grid.length;
        if ( m == 0 )
            return 0;
        final int n = grid[0].length;
        if ( n == 0 )
            return 0;

        int[][] dp = new int[m + 1][n + 1];
        for ( int j = 0; j <= n; ++j )
            dp[0][j] = 1;

        for ( int i = 0; i <= m; ++i  )
            dp[i][0] = 1;

        for ( int i = 1; i <= m; ++i ) {
            for ( int j = 1; j <= n; ++j ) {
                if ( grid[i - 1][j - 1] == 1 ) {
                    dp[i][j] = 0; // reaching this cell is not possible
                } else if ( i == 1 ) { // for first row, take value from previous column
                    dp[i][j] = dp[i][j - 1];
                } else if ( j == 1 ) { // for first column, take value from previous row
                    dp[i][j] = dp[i - 1][j];
                } else { // take sum of values from top & left cell
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }

}
