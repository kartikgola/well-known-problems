/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Outer loop should only go till `n/2`, which is equal to the number of layers in the matrix
        for ( int i = 0; i < n / 2; ++i ) {
            // Inner loop goes for `n-i-1`, which is equal to number of elements in a layer row minus one
            for ( int j = i; j < n - i - 1; ++j ) {
                // i = 0, j = 0
                // 00 -> 03 -> 33 -> 30 -> 00
                // i = 0, j = 1
                // 01 -> 13 -> 32 -> 20 -> 01
                int temp = matrix[i][j];

                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

}
