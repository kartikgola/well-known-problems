/*
 * Author: Kartik Gola
 * Date: 11/03/2021, 16:31
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */

package leetcode;

public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int[][] sums = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0)
                    sums[i][j] = matrix[i][j];
                else if (j == 0)
                    sums[i][j] = matrix[i][j];
                else if (matrix[i][j] == 1) {
                    sums[i][j] = matrix[i][j] + Math.min(sums[i-1][j-1], Math.min(sums[i-1][j], sums[i][j-1]));
                }
                ans += sums[i][j];
            }
        }

        return ans;
    }
}
