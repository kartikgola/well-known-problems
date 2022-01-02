/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class LongestLineOfConsecutiveOneInMatrix {

    boolean[][] vi;
    int[][][] dp;

    int[] f(int i, int j, int[][] mat) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0)
            return new int[4];
        if (vi[i][j])
            return dp[i][j];
        vi[i][j] = true;
        // we only consider right, diag, vert and anti-diagonal in right-downward direction
        // since we are always traversing the matrix from Left to right, top to bottom
        int[] right = f(i, j+1, mat);
        int[] diag = f(i+1, j, mat);
        int[] vert = f(i+1, j+1, mat);
        int[] adiag = f(i+1, j-1, mat);
        return dp[i][j] = new int[]{1+right[0], 1+diag[1], 1+vert[2], 1+adiag[3]};
    }

    public int longestLine(int[][] mat) {
        int ans = 0;
        vi = new boolean[mat.length][mat[0].length];
        dp = new int[mat.length][mat[0].length][4];
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 1) {
                    int[] res = f(i, j, mat);
                    for (int val: res)
                        ans = Math.max(ans, val);
                }
            }
        }
        return ans;
    }
}
