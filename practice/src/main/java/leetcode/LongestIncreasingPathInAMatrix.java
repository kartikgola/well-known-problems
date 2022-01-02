/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class LongestIncreasingPathInAMatrix {

    private int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    private int f(int[][] m, int p, int i, int j, int[][] dp) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[i].length || m[i][j] <= p)
            return -1;
        if (dp[i][j] > 0)
            return dp[i][j];
        int ans = 1;
        int temp = m[i][j];
        m[i][j] = -1;
        for (int[] po: pos) {
            ans = Math.max(ans, 1+f(m, temp, po[0]+i, po[1]+j, dp));
        }
        m[i][j] = temp;
        return dp[i][j] = ans;
    }

    public int longestIncreasingPath(int[][] m) {
        int ans = 0;
        int[][] dp = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[i].length; ++j) {
                ans = Math.max(ans, f(m, -1, i, j, dp));
            }
        }
        return ans;
    }
}
