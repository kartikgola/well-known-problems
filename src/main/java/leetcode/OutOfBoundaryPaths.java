/*
 * Author: Kartik Gola
 * Date: 1/16/21, 8:18 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/out-of-boundary-paths/
 */

package leetcode;

public class OutOfBoundaryPaths {

    public int findPaths(int m, int n, int N, int i, int j) {
        final int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        final int MOD = 1000_000_007;
        int[][][] dp = new int[m][n][N+1];
        int ways = 0;

        for (int move = 1; move <= N; ++move) {
            for (int k = 0; k < m; ++k) {
                for (int l = 0; l < n; ++l) {
                    for (int[] p: pos) {
                        final int x = p[0] + k;
                        final int y = p[1] + l;
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            dp[k][l][move] += dp[x][y][move-1];
                        } else {
                            dp[k][l][move]++;
                        }
                        dp[k][l][move] %= MOD;
                    }
                }
            }
        }

        return dp[i][j][N];
    }
}
