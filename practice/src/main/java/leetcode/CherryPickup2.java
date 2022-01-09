/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class CherryPickup2 {

    public int cherryPickup(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        // dp[i][j][k] = Max cherries that ith row can get when robot 1 & 2 are at j & k respectively
        // *** Intuition for 3D DP matrix ***
        // For a row 'i', the 2 robots can come from any of the 'n' previous columns
        // So, for row 'i', we can have 'n^2' choices, which explains the need for m.n.n matrix
        // A little gotcha - Technically, for row 'i' and a given (j, k), the 2 robots can come from max
        // 6 points of next row : (i,j-1,k), (i,j,k), (i,j+1,k), (i,j,k-1), (i,j,k), (i,j,k+1) of the next row 'i+1'

        for (int i = m - 1; i > -1; --i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    // Count of current row's cherries
                    int count = j == k ? grid[i][j] : grid[i][j] + grid[i][k];
                    // Count of next row's max cherries
                    int nextCount = 0;
                    if (i < m-1) {
                        // From 'i+1'th row, we check all the (j,k) pairs where j,k can be from -1,0 or +1 direction
                        int[] pos = new int[]{-1, 0, 1};
                        for (int pj: pos) {
                            for (int pk: pos) {
                                if ((j + pj) > -1 && (j + pj) < n && (k + pk) > -1 && (k + pk) < n) {
                                    nextCount = Math.max(nextCount, dp[i+1][j + pj][k + pk]);
                                }
                            }
                        }
                    }
                    dp[i][j][k] = count + nextCount;
                }
            }
        }

        return dp[0][0][n-1];
    }

    private int f(int[][] grid, Integer[][][] dp, int row, int c1, int c2) {
        if (row >= grid.length)
            return 0;

        int cherries = 0;
        if (dp[row][c1][c2] != null)
            return dp[row][c1][c2];

        // if col index of robots is same, only one of them will get the cherries; otherwise both will get
        int curr = c1 == c2 ? grid[row][c1] : grid[row][c1] + grid[row][c2];
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                int c11 = c1 + i;
                int c22 = c2 + j;
                if (c11 >= 0 && c11 < grid[0].length && c22 >= 0 && c22 < grid[0].length) {
                    cherries = Math.max(cherries, curr + f(grid, dp, row+1, c11, c22));
                }
            }
        }

        return dp[row][c1][c2] = cherries;
    }

    public int cherryPickup2(int[][] grid) {
        // dp[i][j][k] = max cherries collected at ith row, when R1 is at j and R2 is at k
        return f(grid, new Integer[grid.length][grid[0].length][grid[0].length], 0, 0, grid[0].length-1);
    }
}