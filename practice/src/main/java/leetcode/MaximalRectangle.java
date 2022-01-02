/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1')
                    dp[j]++;
                else
                    dp[j] = 0;
            }
            maxarea = Math.max(maxarea, new LargestRectangleInHistogram().largestRectangleArea2(dp));
        }

        return maxarea;
    }
}
